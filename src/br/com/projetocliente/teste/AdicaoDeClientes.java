package br.com.projetocliente.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.projetocliente.modelo.Clientes;

public class AdicaoDeClientes {

	public static void main(String[] args) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
	    configuration.configure();
	    
	    SessionFactory factory = configuration.buildSessionFactory();
	    Session session = factory.openSession();
	    
	    Clientes cliente = new Clientes();
	    cliente.setNome_cliente("Matheus");
	    cliente.setCod_tip_cliente(10);
	  
	    Transaction tx = session.beginTransaction();
	    session.save(cliente);        
	    tx.commit();
	 }
}