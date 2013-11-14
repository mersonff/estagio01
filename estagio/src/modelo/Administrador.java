package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Administrador {
	
	@Id
	private String login;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
