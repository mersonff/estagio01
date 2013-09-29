package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Exame {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cpfPaciente;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	private String nomePaciente;
	
	/*@ManyToOne
	private Paciente paciente;
	
	public Exame(){
		this.paciente = new Paciente();
	}
*/
	

	public Date getData() {
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

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

/*	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
*/
}
