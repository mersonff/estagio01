package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Exame.autoComplete", 
			    query="select e.solicitante from Exame e where e.solicitante LIKE :solicitante"),
	@NamedQuery(name="Exame.quantGeralExame", 
			    query="select e from Exame e where e.dataEntrega >= :dataInicio and e.dataEntrega <= :dataFim"),
	@NamedQuery(name="Exame.quantTipoExame", 
			    query="select e from Exame e where e.dataEntrega >= :dataInicio and e.dataEntrega <= :dataFim and e.nomeTipo = :nomeTipo")			    
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idExame;
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	@Temporal(TemporalType.DATE)
	private Date dataAgendamento;
	private String status;
	@ManyToOne
	@JoinColumn(name = "numeroSus")
	private Paciente paciente;
	private String solicitante;
	private String nomeTipo;
	private boolean hoje;

	public Exame() {
		this.paciente = new Paciente();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public boolean isHoje() {
		Calendar dataAgend = new GregorianCalendar();
		dataAgend.setTime(dataAgendamento);
		Calendar datahoje = Calendar.getInstance();
		if (dataAgend.get(Calendar.DATE) == datahoje.get(Calendar.DATE)
				&& dataAgend.get(Calendar.MONTH) == datahoje
						.get(Calendar.MONTH)
				&& dataAgend.get(Calendar.YEAR) == datahoje.get(Calendar.YEAR)) {
			hoje = true;
		} else {
			hoje = false;
		}
		return hoje;

	}

	public void setHoje(boolean hoje) {
		this.hoje = hoje;
	}

}
