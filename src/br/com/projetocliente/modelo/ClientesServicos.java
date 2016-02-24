package br.com.projetocliente.modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
public class ClientesServicos {
    
	@Id @GeneratedValue
	private int id_cliente_servico;
	
	private int id_cliente;
	private int id_servico;
	
	private Date data_ini;
	private Date data_fim;
	private Date data_pagamento;
	
	public int getIdCliente() {
		return id_cliente;
	}
	public void setIdCliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getIdServico() {
		return id_servico;
	}
	public void setIdServico(int id_servico) {
		this.id_servico = id_servico;
	}
	public Date getDataIni() {
		return data_ini;
	}
	public void setDataIni(Date data_ini) {
		this.data_ini = data_ini;
	}
	public Date getDataFim() {
		return data_fim;
	}
	public void setDataFim(Date data_fim) {
		this.data_fim = data_fim;
	}
	public Date getDataPagamento() {
		return data_pagamento;
	}
	public void setDataPagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}
	
}
