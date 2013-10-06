package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Baciloscopia extends Exame {
	private String unidadeDeSaude;
	private String prontuario;

	private String materialClinico;
	private String outros;
	private boolean diagnostico;
	private boolean controleDeTratamento;
	private int numeroDaAmostra;
	private int mesDaAmostra;

	public Baciloscopia() {

	}

	public String getUnidadeDeSaude() {
		return unidadeDeSaude;
	}

	public void setUnidadeDeSaude(String unidadeDeSaude) {
		this.unidadeDeSaude = unidadeDeSaude;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getMaterialClinico() {
		return materialClinico;
	}

	public void setMaterialClinico(String materialClinico) {
		this.materialClinico = materialClinico;
	}

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}

	public boolean getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(boolean diagnostico) {
		this.diagnostico = diagnostico;
	}

	public int getNumeroDaAmostra() {
		return numeroDaAmostra;
	}

	public void setNumeroDaAmostra(int numeroDaAmostra) {
		this.numeroDaAmostra = numeroDaAmostra;
	}

	public int getMesDaAmostra() {
		return mesDaAmostra;
	}

	public void setMesDaAmostra(int mesDaAmostra) {
		this.mesDaAmostra = mesDaAmostra;
	}

	public boolean isControleDeTratamento() {
		return controleDeTratamento;
	}

	public void setControleDeTratamento(boolean controleDeTratamento) {
		this.controleDeTratamento = controleDeTratamento;
	}

}
