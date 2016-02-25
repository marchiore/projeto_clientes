package br.com.projetocliente.modelo;

import javax.persistence.*;

@Entity
@Table(name="tipo_cliente")
public class TipoCliente {
    
	@Id 
	@Column(name = "cod_tip_cliente")
	private int codTipCliente;
	
	@Column(name = "pct_desc")
	private double pctDesc;

	public void setCodTipCliente(int cod_tip_cliente) {
		this.codTipCliente = cod_tip_cliente;
	}

	public void setPctDesc(double pct_desc) {
		this.pctDesc = pct_desc;
	}

	public int getCodTipCliente() {
		return codTipCliente;
	}

	public double getPctDesc() {
		return pctDesc;
	}
	

}
