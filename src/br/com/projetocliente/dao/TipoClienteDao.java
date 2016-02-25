package br.com.projetocliente.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetocliente.modelo.Clientes;
import br.com.projetocliente.modelo.Servicos;
import br.com.projetocliente.modelo.TipoCliente;
import br.com.projetocliente.util.SessionCreator;

public class TipoClienteDao {
	private final Session session;
	public TipoClienteDao() {
		this.session = SessionCreator.getSession();
	}
	
	//método para gravar
	public void save(TipoCliente tipoCliente) {		
		Transaction tx = session.beginTransaction();
	    session.save(tipoCliente);        
	    tx.commit();
	}

	//método para atualizar
	public void update(TipoCliente tipoCliente) {		
		Transaction tx = session.beginTransaction();
	    session.update(tipoCliente);        
	    tx.commit();
	}
	
	//método para atualizar
	public void delete(TipoCliente tipoCliente) {		
		Transaction tx = session.beginTransaction();
	    session.delete(tipoCliente);        
	    tx.commit();
	}
	
	public TipoCliente select(int tipCli){
		TipoCliente tipoCliente = (TipoCliente) session.load(TipoCliente.class, tipCli);
		
		return tipoCliente;
	}
}
