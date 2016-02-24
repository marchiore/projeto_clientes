package br.com.projetocliente.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetocliente.modelo.Clientes;
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
	public void update(Clientes cliente) {		
		Transaction tx = session.beginTransaction();
	    session.update(cliente);        
	    tx.commit();
	}
	
	//método para atualizar
	public void delete(Clientes cliente) {		
		Transaction tx = session.beginTransaction();
	    session.delete(cliente);        
	    tx.commit();
	}
}
