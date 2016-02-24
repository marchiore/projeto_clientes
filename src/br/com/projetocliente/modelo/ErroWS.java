package br.com.projetocliente.modelo;

public class ErroWS {
	private int codigoErro = 0;
	private String mensagemAuxiliar = "";
	
	public int getCodigoErro() {
		return codigoErro;
	}
	public void setCodigoErro(int codigoErro) {
		this.codigoErro = codigoErro;
	}
	public String getMensagemAuxiliar() {
		return mensagemAuxiliar;
	}
	public void setMensagemAuxiliar(String mensagemAuxiliar) {
		this.mensagemAuxiliar = mensagemAuxiliar;
	}
	
	public ErroWS(){
		this.codigoErro = 0;
		this.mensagemAuxiliar = "";
	} 

}
