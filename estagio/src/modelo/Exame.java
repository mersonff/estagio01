package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idExame;
	private String dataPedido;
	private String status;
	@ManyToOne
	@JoinColumn(name = "numeroSus")
	private Paciente paciente;
	private String nomeTipo;
	@OneToOne
	@JoinColumn(name = "idExame")
	private Resultado resultado;

	public Exame() {
		this.paciente = new Paciente();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getIdExame() {
		return idExame;
	}

	public void setIdExame(long idExame) {
		this.idExame = idExame;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

}
