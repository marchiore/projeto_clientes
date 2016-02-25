package br.com.projetocliente.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.Days;

import br.com.projetocliente.modelo.Clientes;
import br.com.projetocliente.modelo.ClientesServicos;
import br.com.projetocliente.modelo.Servicos;
import br.com.projetocliente.modelo.TipoCliente;
import br.com.projetocliente.util.SessionCreator;

public class ClientesServicosDao {
private final Session session;
	
	public ClientesServicosDao() {
		this.session = SessionCreator.getSession();
	}
	
	//método para gravar
	public void save(ClientesServicos clienteServico) {		
		Transaction tx = session.beginTransaction();
	    session.save(clienteServico);        
	    tx.commit();
	}

	//método para atualizar
	public void update(ClientesServicos clienteServico) {		
		Transaction tx = session.beginTransaction();
	    session.update(clienteServico);        
	    tx.commit();
	}
	
	//método para atualizar
	public void delete(ClientesServicos clienteServico) {		
		Transaction tx = session.beginTransaction();
	    session.delete(clienteServico);        
	    tx.commit();
	}
	
	//método para atualizar
	public List<Object> consultarTodos() {		
		
		Query query = session.createQuery("from ClientesServicos"); 
	    List<Object> list = query.list();
	    
//	    for (Clientes clientes : list) {
//			System.out.println(list);
//		}
	    
	    return list;
	}
	
	public ClientesServicos select(int idServico){
		ClientesServicos servico = (ClientesServicos) session.load(ClientesServicos.class, idServico);
		
		return servico;
	}
	
	
	public double getValorServico(int iCodServico){		
		double dValorServico = 0D;
		
		ClientesServicos clienteServico = new ClientesServicosDao().select(iCodServico);		
		Servicos servico = new ServicosDao().select(clienteServico.getIdServico());		
		Clientes cliente = new ClienteDao().select(clienteServico.getIdCliente());
		TipoCliente tipoCliente = new TipoClienteDao().select(cliente.getCodTipCliente());
		
		double dValorTotalServico = servico.getValorServico();
		double dPctDescCliente = tipoCliente.getPctDesc();
		
		int days = Days.daysBetween(new DateTime(clienteServico.getDataPagamento()), new DateTime(clienteServico.getDataFim())).getDays();
		
		if(clienteServico.getDataPagamento()!= null && days < 10){
			//adiciona 5% de desconto no valor total
			dPctDescCliente += 5;		
		}					
		System.out.println("Aplicando Desconto de ->" + dPctDescCliente);
		dValorServico = dValorTotalServico - (dPctDescCliente / 100) * dValorTotalServico;
		
		return dValorServico;
	}
	
}
