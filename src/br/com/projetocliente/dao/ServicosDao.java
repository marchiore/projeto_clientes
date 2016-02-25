package br.com.projetocliente.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetocliente.modelo.Clientes;
import br.com.projetocliente.modelo.Servicos;
import br.com.projetocliente.util.SessionCreator;

public class ServicosDao {
	private final Session session;
	public ServicosDao() {
		this.session = SessionCreator.getSession();
	}
	
	//método para gravar
	public void save(Servicos servicos) {		
		Transaction tx = session.beginTransaction();
	    session.save(servicos);        
	    tx.commit();
	}

	//método para atualizar
	public void update(Servicos servicos) {		
		Transaction tx = session.beginTransaction();
	    session.update(servicos);        
	    tx.commit();
	}
	
	//método para atualizar
	public void delete(Servicos servicos) {		
		Transaction tx = session.beginTransaction();
	    session.delete(servicos);        
	    tx.commit();
	}
	
	public Servicos select(int idServico){
		Servicos servico = (Servicos) session.load(Servicos.class, idServico);
		
		return servico;
	}
}
