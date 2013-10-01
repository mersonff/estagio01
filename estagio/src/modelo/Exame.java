package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Exame {

	@Id
	private long cpfPaciente;
	private String dataNascimento;

	private String nomePaciente;

	/*
	 * @ManyToOne private Paciente paciente;
	 * 
	 * public Exame(){ this.paciente = new Paciente(); }
	 */

	public String getData() {
		return dataNascimento;
	}

	public long getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(long cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	/*
	 * public Paciente getPaciente() { return paciente; }
	 * 
	 * public void setPaciente(Paciente paciente) { this.paciente = paciente; }
	 */
}
