package br.com.projetocliente.modelo;

import java.util.Date;

import javax.persistence.*;

import org.joda.time.DateTime;
import org.joda.time.Days;

@Entity
@Table(name="clientes_servicos")
public class ClientesServicos {
    
	@Id @GeneratedValue
	@Column(name = "id_cliente_servico")
	private int idClienteServico;
	
	@Column(name = "id_cliente")
	private int idCliente;
	
	@Column(name = "id_servico")
	private int idServico;
	
	@Column(name = "data_ini")
	private Date dataIni;
	
	@Column(name = "data_fim")
	private Date dataFim;
	
	@Column(name = "data_pagamento")
	private Date datPagamento;
	
	@Transient
	private int iDiasRestantes;
	
	public int getiDiasRestantes() {			
		return Days.daysBetween(new DateTime(new Date()), new DateTime(this.getDataFim())).getDays();
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int id_cliente) {
		this.idCliente = id_cliente;
	}
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int id_servico) {
		this.idServico = id_servico;
	}
	public Date getDataIni() {
		return dataIni;
	}
	public void setDataIni(Date data_ini) {
		this.dataIni = data_ini;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date data_fim) {
		this.dataFim = data_fim;
	}
	public Date getDataPagamento() {
		return datPagamento;
	}
	public void setDataPagamento(Date data_pagamento) {
		this.datPagamento = data_pagamento;
	}
	
}
