package br.com.projetocliente.services;

import java.util.Date;

import br.com.projetocliente.dao.ClientesServicosDao;
import br.com.projetocliente.modelo.ClientesServicos;

public class ClientesServicosService {
	public void createClienteServicos(int idCliente, int idServico, Date dataIni, Date dataFim, Date dataPagamento) {
		ClientesServicos clienteServicos = new ClientesServicos();
		clienteServicos.setIdCliente(idCliente);
		clienteServicos.setIdServico(idServico);
		clienteServicos.setDataPagamento(dataPagamento);
		clienteServicos.setDataIni(dataIni);
		clienteServicos.setDataFim(dataFim);
		
		new ClientesServicosDao().save(clienteServicos);
	}
	
	public double getValorComDescServico(int idClienteServico){		
		return new ClientesServicosDao().getValorServico(idClienteServico);		
	}
	
	
}
