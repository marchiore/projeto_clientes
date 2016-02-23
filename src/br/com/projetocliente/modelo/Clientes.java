package br.com.projetocliente.modelo;

import javax.persistence.*;

@Entity
public class Clientes {
    
	@Id @GeneratedValue
	private int id_cliente;
	
	//@Column(name = "nome_cliente")
	private String nome_cliente;
	
	//@Column(name = "cod_tip_cliente")
	private int cod_tip_cliente;
	
	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public int getCod_tip_cliente() {
		return cod_tip_cliente;
	}

	public void setCod_tip_cliente(int cod_tip_cliente) {
		this.cod_tip_cliente = cod_tip_cliente;
	}

	
	
	
	
}
