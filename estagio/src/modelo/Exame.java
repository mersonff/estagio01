package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exame {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@OneToOne
	private TipoDeExame tipo;
	
	@ManyToOne
	private Paciente paciente;
	
	public Exame(){
		this.tipo = new TipoDeExame();
		this.paciente = new Paciente();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoDeExame getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeExame tipo) {
		this.tipo = tipo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
