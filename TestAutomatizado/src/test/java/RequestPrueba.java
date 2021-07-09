public class RequestPrueba{
	private int numeroConta;
	private int valor;
	private String comprobante;
	private String tipoConta;
	private String referencia;
	private String concepto;

	public void setNumeroConta(int numeroConta){
		this.numeroConta = numeroConta;
	}

	public int getNumeroConta(){
		return numeroConta;
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

	public void setTipoConta(String tipoConta){
		this.tipoConta = tipoConta;
	}

	public String getTipoConta(){
		return tipoConta;
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
}
