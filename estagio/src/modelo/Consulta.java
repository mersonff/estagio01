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
@SequenceGenerator(name = "sequencia_consultas", sequenceName = "sequencia_consultas") 
//
public class Consulta {
	@Id
	//Adicionado por David Costa
	@GeneratedValue(strategy = GenerationType.AUTO, generator="sequencia_consultas")
	//
	private long idConsulta;
	@Temporal(TemporalType.DATE)
	private Date data;
	private String tipoConsulta;
	private String tipoAtendimento;
	
	//Acrescentado por David Costa
	private String profissionalAtendente;
	private String areaAtendimento;
	private String observacao;
	//
	
	@ManyToOne
	@JoinColumn(name = "numeroSus")
	private Paciente paciente;

	public Consulta() {
		this.paciente = new Paciente();
	}

	public long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public String getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	//Adicionado por David Costa
	public String getProfissionalAtendente() {
		return profissionalAtendente;
	}

	public void setProfissionalAtendente(String profissionalAtendente) {
		this.profissionalAtendente = profissionalAtendente;
	}

	public String getAreaAtendimento() {
		return areaAtendimento;
	}

	public void setAreaAtendimento(String areaAtendimento) {
		this.areaAtendimento = areaAtendimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	//
	
}
