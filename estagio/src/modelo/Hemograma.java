package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Hemograma extends Exame {
	// Dados do Pedido
	private String leito;

	// Dados do Resultado
	private double hemacias;
	private double vcm;
	private double hemoglobina;
	private double hcm;
	private double hematocrito;
	private double chcm;

	private double leucocitos;
	private double metamiei;
	private double bastoes;
	private double segmentacao;
	private double eosinof;
	private double basofilos;
	private double linfocitos;
	private double monocitos;

	private String tipoHemacias;
	private String tipoPlaquetas;
	private String tipoLinfocitos;
	private String tipoGranulacoes;
	private String tipoEritroblastos;

	public Hemograma() {
		setNomeTipo("Hemograma");
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}

	public double getHemacias() {
		return hemacias;
	}

	public void setHemacias(double hemacias) {
		this.hemacias = hemacias;
	}

	public double getVcm() {
		return vcm;
	}

	public void setVcm(double vcm) {
		this.vcm = vcm;
	}

	public double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public double getHcm() {
		return hcm;
	}

	public void setHcm(double hcm) {
		this.hcm = hcm;
	}

	public double getHematocrito() {
		return hematocrito;
	}

	public void setHematocrito(double hematocrito) {
		this.hematocrito = hematocrito;
	}

	public double getChcm() {
		return chcm;
	}

	public void setChcm(double chcm) {
		this.chcm = chcm;
	}

	public double getLeucocitos() {
		return leucocitos;
	}

	public void setLeucocitos(double leucocitos) {
		this.leucocitos = leucocitos;
	}

	public double getMetamiei() {
		return metamiei;
	}

	public void setMetamiei(double metamiei) {
		this.metamiei = metamiei;
	}

	public double getBastoes() {
		return bastoes;
	}

	public void setBastoes(double bastoes) {
		this.bastoes = bastoes;
	}

	public double getSegmentacao() {
		return segmentacao;
	}

	public void setSegmentacao(double segmentacao) {
		this.segmentacao = segmentacao;
	}

	public double getEosinof() {
		return eosinof;
	}

	public void setEosinof(double eosinof) {
		this.eosinof = eosinof;
	}

	public double getBasofilos() {
		return basofilos;
	}

	public void setBasofilos(double basofilos) {
		this.basofilos = basofilos;
	}

	public double getLinfocitos() {
		return linfocitos;
	}

	public void setLinfocitos(double linfocitos) {
		this.linfocitos = linfocitos;
	}

	public double getMonocitos() {
		return monocitos;
	}

	public void setMonocitos(double monocitos) {
		this.monocitos = monocitos;
	}

	public String getTipoHemacias() {
		return tipoHemacias;
	}

	public void setTipoHemacias(String tipoHemacias) {
		this.tipoHemacias = tipoHemacias;
	}

	public String getTipoPlaquetas() {
		return tipoPlaquetas;
	}

	public void setTipoPlaquetas(String tipoPlaquetas) {
		this.tipoPlaquetas = tipoPlaquetas;
	}

	public String getTipoLinfocitos() {
		return tipoLinfocitos;
	}

	public void setTipoLinfocitos(String tipoLinfocitos) {
		this.tipoLinfocitos = tipoLinfocitos;
	}

	public String getTipoGranulacoes() {
		return tipoGranulacoes;
	}

	public void setTipoGranulacoes(String tipoGranulacoes) {
		this.tipoGranulacoes = tipoGranulacoes;
	}

	public String getTipoEritroblastos() {
		return tipoEritroblastos;
	}

	public void setTipoEritroblastos(String tipoEritroblastos) {
		this.tipoEritroblastos = tipoEritroblastos;
	}
	
	

}
