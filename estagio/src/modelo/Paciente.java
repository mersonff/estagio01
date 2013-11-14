package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paciente {
	@Id
	private long numeroSus;
	private String nome;
	private String sobrenome;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private String endereco;
	private String localidade;
	private String sexo;
	private int idade;
	@OneToMany(mappedBy = "paciente")
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		if (dataNascimento != null) {
			Calendar dataNasc = new GregorianCalendar();
			dataNasc.setTime(dataNascimento);
			Calendar hoje = Calendar.getInstance();
			idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
			dataNasc.add(Calendar.YEAR, idade);
			if (hoje.before(dataNasc)) {
				idade--;
			}
			return idade;
		} else {
			return 0;
		}
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
