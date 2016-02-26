package br.com.projetocliente.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetocliente.modelo.Clientes;
import br.com.projetocliente.modelo.ClientesServicos;
import br.com.projetocliente.util.SessionCreator;

public class ClienteDao {
	private final Session session;
	
	public ClienteDao() {
		this.session = SessionCreator.getSession();
	}
	
	//método para gravar
	public void save(Clientes cliente) {		
		Transaction tx = session.beginTransaction();
	    session.save(cliente);        
	    tx.commit();
	}

	//método para atualizar
	public void update(String nome, int tipoCliente, int idCliente) {	
		
		Clientes cliente = (Clientes) session.load(Clientes.class, idCliente);
		cliente.setCodTipCliente(tipoCliente);
		cliente.setNomeCliente(nome);
		
		Transaction tx = session.beginTransaction();
	    session.update(cliente);        
	    tx.commit();
	    
	}
	
	//método para atualizar
	public void delete(int idCliente) {		
		
		Clientes cliente = (Clientes) session.load(Clientes.class, idCliente);
		
		Transaction tx = session.beginTransaction();
	    session.delete(cliente);        
	    tx.commit();
	}
	
	public Clientes select(int idCliente){
		Clientes cliente = (Clientes) session.load(Clientes.class, idCliente);
		
		return cliente;
	}
	
	public List<ClientesServicos> getServicos(int idCliente){
		Clientes cliente = new ClienteDao().select(idCliente);
		return cliente.getListClientesServicos();
		
//		for (ClientesServicos clientesServicos : listServicos) {
//			System.out.println(clientesServicos.getDataIni());
//		}		
	}
	
}
