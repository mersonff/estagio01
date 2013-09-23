package util;

public class Mensagem {
	
	private boolean erro;
	private boolean sucesso;
	private String msg;
	
	public Mensagem(String msg, boolean sucesso, boolean erro){
		this.msg = msg;
		this.sucesso = sucesso;
		this.erro = erro;
	}
	
	public boolean isErro() {
		return erro;
	}
	
	public void setErro(boolean erro) {
		this.erro = erro;
	}
	
	public boolean isSucesso() {
		return sucesso;
	}
	
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
