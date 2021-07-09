public class Request2{
	private int tipoNumeroConta;
	private int valor;
	private String comprobante;
	private String referencia;
	private String concepto;
	private String tipoConta;

	public void setTipoNumeroConta(int tipoNumeroConta){
		this.tipoNumeroConta = tipoNumeroConta;
	}

	public int getTipoNumeroConta(){
		return tipoNumeroConta;
	}

	public void setValor(int valor){
		this.valor = valor;
	}

	public int getValor(){
		return valor;
	}

	public void setComprobante(String comprobante){
		this.comprobante = comprobante;
	}

	public String getComprobante(){
		return comprobante;
	}

	public void setReferencia(String referencia){
		this.referencia = referencia;
	}

	public String getReferencia(){
		return referencia;
	}

	public void setConcepto(String concepto){
		this.concepto = concepto;
	}

	public String getConcepto(){
		return concepto;
	}

	public void setTipoConta(String tipoConta){
		this.tipoConta = tipoConta;
	}

	public String getTipoConta(){
		return tipoConta;
	}
}
