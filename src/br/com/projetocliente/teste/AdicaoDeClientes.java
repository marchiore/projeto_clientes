package br.com.projetocliente.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.projetocliente.dao.ClienteDao;
import br.com.projetocliente.modelo.Clientes;
import br.com.projetocliente.util.SessionCreator;

public class AdicaoDeClientes {

	public static void main(String[] args) {			    
	    Clientes cliente = createCliente();
	  
	    new ClienteDao().save(cliente);
		
//		AnnotationConfiguration configuration = new AnnotationConfiguration();
//	    configuration.configure();
//	    
//	    SessionFactory factory = configuration.buildSessionFactory();
//	    Session session = factory.openSession();
//	    
//	    // carrega o produto do banco de dados
//	    Clientes produto = (Clientes) session.load(Clientes.class, 4);
//     
//	    Transaction tx = session.beginTransaction();
//	    produto.setNomeCliente("valdo");
//	    session.update(produto);
//	  	            
//	    tx.commit();
	 }

	private static Clientes createCliente() {
		Clientes cliente = new Clientes();
	    cliente.setNomeCliente("Matheus");
	    cliente.setCodTipCliente(10);
		return cliente;
	}

	
}