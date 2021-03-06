package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//Adicionado por David Costa
@SequenceGenerator(name = "sequencia_internamentos", sequenceName = "sequencia_internamentos") 
//
public class Internamento {
	@Id
	//Adicionado por David Costa
	@GeneratedValue(strategy = GenerationType.AUTO, generator="sequencia_internamentos")
	//
	private long idInternamento;
	@Temporal(TemporalType.DATE)
	private Date data;
	private String leito;
	@ManyToOne
	@JoinColumn(name = "numeroSus")
	private Paciente paciente;

	public Internamento() {
		this.paciente = new Paciente();
	}

	public long getIdInternamento() {
		return idInternamento;
	}

	public void setIdInternamento(long idInternamento) {
		this.idInternamento = idInternamento;
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
