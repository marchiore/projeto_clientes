package br.com.projetocliente.modelo;

import javax.persistence.*;

@Entity
public class Servicos {
    
	@Id @GeneratedValue
	private int id_servico;
	
	//@Column(name = "nome_cliente")
	private String nome_servico;
	
	//@Column(name = "cod_tip_cliente")
	private double valor_servico;

	public String getNome_servico() {
		return nome_servico;
	}

	public void setNomeServico(String nome_servico) {
		this.nome_servico = nome_servico;
	}

	public double getValorServico() {
		return valor_servico;
	}

	public void setValorservico(double valor_servico) {
		this.valor_servico = valor_servico;
	}
		
}
