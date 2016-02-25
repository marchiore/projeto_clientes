package br.com.projetocliente.modelo;

import java.util.List;

import javax.persistence.*;

@Entity
public class Servicos {
    
	@Id @GeneratedValue
	@Column(name = "id_servico")
	private int idServico;
	
	@Column(name = "nome_servico")
	private String nomeServico;
	
	@Column(name = "valor_servico")
	private double valorServico;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="idServico")
	private List<ClientesServicos> listClientesServicos;
	
	public List<ClientesServicos> getListClientesServicos() {
		return listClientesServicos;
	}
	
	public String getNome_servico() {
		return nomeServico;
	}

	public void setNomeServico(String nome_servico) {
		this.nomeServico = nome_servico;
	}

	public double getValorServico() {
		return valorServico;
	}

	public void setValorservico(double valor_servico) {
		this.valorServico = valor_servico;
	}
		
}
