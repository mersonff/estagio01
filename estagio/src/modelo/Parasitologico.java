package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Parasitologico extends Exame {

	private String leito;
	private String medicoSolicitante;
	private String prontuario;
	private String enfermaria;
	private String unidade;

	public Parasitologico() {
		setNomeTipo("Parasitológico");
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

}
