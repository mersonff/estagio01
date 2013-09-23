package util;

public class Usuario {
	
	private long login;
	private String senha;
	private String tipo;
	
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getLogin() {
		return login;
	}

	public void setLogin(long login) {
		this.login = login;
	}
	
	

}
