package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Administrador {
	
	@Id
	private long login;
	private String senha;
	private String nome;
	

	public Administrador() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
