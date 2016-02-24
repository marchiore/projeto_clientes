package br.com.projetocliente.modelo;

import javax.persistence.*;

@Entity
public class TipoCliente {
    
	@Id 
	private int cod_tip_cliente;
	
	private double pct_desc;

	public void setCodTipCliente(int cod_tip_cliente) {
		this.cod_tip_cliente = cod_tip_cliente;
	}

	public void setPctDesc(double pct_desc) {
		this.pct_desc = pct_desc;
	}

}
