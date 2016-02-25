package br.com.projetocliente.modelo;

import java.util.List;

import javax.persistence.*;

@Entity
public class Clientes {
    
	@Id @GeneratedValue
	@Column(name = "id_cliente")
	private int idCliente;
	
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	@Column(name = "cod_tip_cliente")
	private int codTipCliente;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="idCliente")
	private List<ClientesServicos> listClientesServicos;
	
	public List<ClientesServicos> getListClientesServicos() {
		return listClientesServicos;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nome_cliente) {
		this.nomeCliente = nome_cliente;
	}

	public int getCodTipCliente() {
		return codTipCliente;
	}

	public void setCodTipCliente(int cod_tip_cliente) {
		this.codTipCliente = cod_tip_cliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
