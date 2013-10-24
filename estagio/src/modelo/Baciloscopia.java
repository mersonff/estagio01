package modelo;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Baciloscopia extends Exame {
	// Dados da Solicitação
	private String unidadeDeSaude;
	private String prontuario;
	private String materialClinico;
	private String outros;
	private boolean diagnostico;
	private boolean controleDeTratamento;
	private int numeroDaAmostra;
	private int mesDaAmostra;

	// Dados do Resultado
	@ElementCollection
	private List<String> aspectoDoEscarro;
	private boolean negativo;
	private boolean baar;
	private String positividade;
	private String observacoes;

	public Baciloscopia() {
		setNomeTipo("Baciloscopia");
		setStatus("Em aberto");
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

	public boolean isDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(boolean diagnostico) {
		this.diagnostico = diagnostico;
	}

	public boolean isControleDeTratamento() {
		return controleDeTratamento;
	}

	public void setControleDeTratamento(boolean controleDeTratamento) {
		this.controleDeTratamento = controleDeTratamento;
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

	public boolean isNegativo() {
		return negativo;
	}

	public void setNegativo(boolean negativo) {
		this.negativo = negativo;
	}

	public boolean isBaar() {
		return baar;
	}

	public void setBaar(boolean baar) {
		this.baar = baar;
	}

	public String getPositividade() {
		return positividade;
	}

	public void setPositividade(String positividade) {
		this.positividade = positividade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<String> getAspectoDoEscarro() {
		return aspectoDoEscarro;
	}

	public void setAspectoDoEscarro(List<String> aspectoDoEscarro) {
		this.aspectoDoEscarro = aspectoDoEscarro;
	}

}
