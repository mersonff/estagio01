package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Operador {
	
	@Id
	private long login;
	private String senha;
	private String nome;
	private String telefone;
	private String email;
	
	public Operador() {
		
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public long getLogin() {
		return login;
	}

	public void setLogin(long login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		

}
