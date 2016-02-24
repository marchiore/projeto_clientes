package br.com.projetocliente.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.projetocliente.modelo.ClientesServicos;
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
}
