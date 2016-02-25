package br.com.projetocliente.services;

import br.com.projetocliente.dao.ServicosDao;
import br.com.projetocliente.modelo.Servicos;

public class ServicosService {

	public void createServicos(String nomeServico, double valorServico) {
		Servicos servicos = new Servicos();
		servicos.setNomeServico(nomeServico);
		servicos.setValorservico(valorServico);

		new ServicosDao().save(servicos);
	}
	
	
}
