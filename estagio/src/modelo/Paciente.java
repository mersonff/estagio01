package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paciente {
	
	@Id
	private long numeroSus;
	private String nome;
	private String localidade;
	private String telefone;
	@OneToMany(mappedBy="paciente")
	private List<Exame> exames;
	
	public Paciente() {
		this.exames = new ArrayList<Exame>();
	}
	
	public long getNumeroSus() {
		return numeroSus;
	}

	public void setNumeroSus(long numeroSus) {
		this.numeroSus = numeroSus;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
	
	

}
