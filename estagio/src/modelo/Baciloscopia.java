package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Baciloscopia extends Exame {
	private String unidadeDeSaude;
	private String prontuario;

	@Temporal(TemporalType.DATE)
	private Date dataSolicitacao;

	@Temporal(TemporalType.DATE)
	private Date dataLiberacao;

	private String sexo;
	private String endereco;
	private String municipio;
	private String materialClinico;
	private String outros;
	private boolean diagnostico;
	private boolean controleDeTratamento;
	private int numeroDaAmostra;
	private int mesDaAmostra;
	private String aspecto;
	private String negativo;
	private String baar;
	private String positividade;
	private String observacoes;

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

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(Date dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
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

	public String getAspecto() {
		return aspecto;
	}

	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
	}

	public String isNegativo() {
		return negativo;
	}

	public void setNegativo(String negativo) {
		this.negativo = negativo;
	}

	public String isBaar() {
		return baar;
	}

	public void setBaar(String baar) {
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

	public boolean isControleDeTratamento() {
		return controleDeTratamento;
	}

	public void setControleDeTratamento(boolean controleDeTratamento) {
		this.controleDeTratamento = controleDeTratamento;
	}

}
