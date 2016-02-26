package br.com.projetocliente.services;

import java.util.List;

import br.com.projetocliente.dao.ClienteDao;
import br.com.projetocliente.dao.ClientesServicosDao;
import br.com.projetocliente.modelo.Clientes;
import br.com.projetocliente.modelo.ClientesServicos;

public class ClienteService {
	
	public void createCliente(String nome, int tipoCliente) {
		Clientes cliente = new Clientes();
	    cliente.setNomeCliente(nome);
	    cliente.setCodTipCliente(tipoCliente);
		
	    new ClienteDao().save(cliente);	    
	}
	
	public void updateCliente(String nome, int tipoCliente, int idCliente) {	
	    new ClienteDao().update(nome, tipoCliente, idCliente);	    
	}
	
	public void deleteCliente(int idCliente) {	
	    new ClienteDao().delete(idCliente);	    
	}
	
	public List<ClientesServicos> selecioanarServicos(int iCodCliente) {
		return new ClienteDao().getServicos(iCodCliente);
	}
	
}
