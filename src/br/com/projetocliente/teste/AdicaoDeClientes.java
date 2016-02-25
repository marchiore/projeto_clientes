package br.com.projetocliente.teste;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sun.istack.internal.logging.Logger;

import br.com.projetocliente.dao.ClienteDao;
import br.com.projetocliente.dao.ClientesServicosDao;
import br.com.projetocliente.dao.ServicosDao;
import br.com.projetocliente.dao.TipoClienteDao;
import br.com.projetocliente.modelo.Clientes;
import br.com.projetocliente.modelo.ClientesServicos;
import br.com.projetocliente.modelo.Servicos;
import br.com.projetocliente.modelo.TipoCliente;
import br.com.projetocliente.services.ClienteService;
import br.com.projetocliente.services.ClientesServicosService;
import br.com.projetocliente.services.ServicosService;
import br.com.projetocliente.util.SessionCreator;

public class AdicaoDeClientes {

	public static void main(String[] args) {	

//		//CRIANDO OS REGISTROS NO BANCO
//		
//		//TIPO CLIENTE
//		TipoCliente tipoOuro = createTipoCliente(1, 10);
//		TipoCliente tipoPrata = createTipoCliente(2, 5);
//		
//		new TipoClienteDao().save(tipoOuro);
//		new TipoClienteDao().save(tipoPrata);
//		
//		//CLIENTES
//		Clientes cliente1 = createCliente("Matheus Z", 1);
//		Clientes cliente2 = createCliente("Joao", 2);
//		Clientes cliente3 = createCliente("Marcela", 2);
//		Clientes cliente4 = createCliente("Lucas", 1);
//		Clientes cliente5 = createCliente("Juliana", 1);
//		
//		new ClienteDao().save(cliente1);
//		new ClienteDao().save(cliente2);
//		new ClienteDao().save(cliente3);
//		new ClienteDao().save(cliente4);
//		new ClienteDao().save(cliente5);
//		
//		//SERVICOS
//		Servicos servico1 = createServicos("Manuten��o X", 150.00);
//		Servicos servico2 = createServicos("Manuten��o Z", 540.00);
//		
//		new ServicosDao().save(servico1);
//		new ServicosDao().save(servico2);
//			
//		//SERVICO CLIENTE
//		ClientesServicos clienteServico = createClienteServicos(1, 1, new Date("01/02/2015"), new Date("01/06/2015"), null);
//		ClientesServicos clienteServico1 = createClienteServicos(1, 2, new Date("01/06/2015"), new Date("01/08/2015"), null);
//		ClientesServicos clienteServico2 = createClienteServicos(2, 1, new Date("01/02/2015"), new Date("01/06/2015"), null);
//			
//		new ClientesServicosDao().save(clienteServico);
//		new ClientesServicosDao().save(clienteServico1);
//		new ClientesServicosDao().save(clienteServico2);
		
		
//		 AnnotationConfiguration configuration = new AnnotationConfiguration();
//	     configuration.configure();
//	     
//	     SessionFactory factory = configuration.buildSessionFactory();
//	     Session session = factory.openSession();
//	     
//	     // carrega o produto do banco de dados
//	     Clientes produto = (Clientes) session.load(Clientes.class, 1);
//	     
//	     System.out.println(produto.getCodTipCliente());
//	     System.out.println(produto.getNomeCliente());
//	     
//	     Transaction tx = session.beginTransaction();
//	     produto.setNomeCliente("Lacraia");
//	     session.update(produto);
//	     tx.commit();
		
		
		//- Cadastrar os clientes da minha empresa		
		ClienteService objClienteService = new ClienteService();
		objClienteService.createCliente("Lecom bauru", 1);
		
		//- Cadastrar os servi�os  que minha empresa oferece
		ServicosService objServicosService = new ServicosService();
		objServicosService.createServicos("Manuten��o Alpha", 500.32);
		
		//-Registrar que meu cliente contratou um servi�o da minha empresa onde possa definir a data de in�cio e de fim do servi�o
		ClientesServicosService objClientesServicosService = new ClientesServicosService();
		objClientesServicosService.createClienteServicos(2, 1, new Date("01/01/2016"), new Date("01/11/2016"), new Date("01/07/2016"));
		
		//- Visualizar quais servi�os meu cliente tem contratado e quantos dias faltam para atingir a data final do servi�o.
		List<ClientesServicos> list = objClienteService.selecioanarServicos(2);
		
		for (ClientesServicos clientesServicos : list) {

			System.out.println("Servi�o ->" + clientesServicos.getIdServico());
			System.out.println("Data Ini ->" + clientesServicos.getDataIni());
			System.out.println("Data Fim ->" + clientesServicos.getDataFim());
			System.out.println("Data Pagamento ->" + clientesServicos.getDataPagamento());
			System.out.println("Dias Restantes ->" + clientesServicos.getiDiasRestantes());
		}
		
		/*
		Tamb�m gostaria de visualizar o valor  dos  servi�os contratados por um cliente, onde:
			- Clientes do tipo Ouro t�m 10% de desconto
			- Clientes do tipo Prata que t�m 5% de desconto
			- Se o pagamento for at� 10  dias antes da data final, dar mais 5% de desconto no c�lculo do valor (considerando a data atual)
		*/
		
		ClientesServicosService objService = new ClientesServicosService();
		double dValorComDesc = objService.getValorComDescServico(1);
		
		System.out.println(dValorComDesc);
		
		
	}



	
}