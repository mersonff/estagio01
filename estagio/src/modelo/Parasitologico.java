package modelo;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Parasitologico extends Exame {
	// Dados do Pedido
	private String leito;
	private String medicoSolicitante;
	private String prontuario;
	private String enfermaria;
	private String unidade;

	// Dados do Resultado
	private String metodo;

	@ElementCollection
	private List<String> ovosDeHelmintos;
	@ElementCollection
	private List<String> protozoarios;

	public Parasitologico() {
		setNomeTipo("Parasitologico de Fezes");
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}

	public String getMedicoSolicitante() {
		return medicoSolicitante;
	}

	public void setMedicoSolicitante(String medicoSolicitante) {
		this.medicoSolicitante = medicoSolicitante;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getEnfermaria() {
		return enfermaria;
	}

	public void setEnfermaria(String enfermaria) {
		this.enfermaria = enfermaria;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public List<String> getOvosDeHelmintos() {
		return ovosDeHelmintos;
	}

	public void setOvosDeHelmintos(List<String> ovosDeHelmintos) {
		this.ovosDeHelmintos = ovosDeHelmintos;
	}

	public List<String> getProtozoarios() {
		return protozoarios;
	}

	public void setProtozoarios(List<String> protozoarios) {
		this.protozoarios = protozoarios;
	}

}
