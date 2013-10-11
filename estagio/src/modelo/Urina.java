package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Urina extends Exame{
	
	private String leito;
	
	private String volume;
	private String cor;
	private String aspecto;
	private String densidade;
	private String ph;

	private String proteina;
	private String glicose;
	private String acetona;
	private String acetoacético;

	private double cilindros;
	private double hemacias;
	private double leucocitos;
	private double celulas;

	private String estudoDetalhado;
	
	public Urina(){
		setNomeTipo("Urina");
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAspecto() {
		return aspecto;
	}

	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
	}

	public String getDensidade() {
		return densidade;
	}

	public void setDensidade(String densidade) {
		this.densidade = densidade;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getProteina() {
		return proteina;
	}

	public void setProteina(String proteina) {
		this.proteina = proteina;
	}

	public String getGlicose() {
		return glicose;
	}

	public void setGlicose(String glicose) {
		this.glicose = glicose;
	}

	public String getAcetona() {
		return acetona;
	}

	public void setAcetona(String acetona) {
		this.acetona = acetona;
	}

	public String getAcetoacético() {
		return acetoacético;
	}

	public void setAcetoacético(String acetoacético) {
		this.acetoacético = acetoacético;
	}

	public double getCilindros() {
		return cilindros;
	}

	public void setCilindros(double cilindros) {
		this.cilindros = cilindros;
	}

	public double getHemacias() {
		return hemacias;
	}

	public void setHemacias(double hemacias) {
		this.hemacias = hemacias;
	}

	public double getLeucocitos() {
		return leucocitos;
	}

	public void setLeucocitos(double leucocitos) {
		this.leucocitos = leucocitos;
	}

	public double getCelulas() {
		return celulas;
	}

	public void setCelulas(double celulas) {
		this.celulas = celulas;
	}

	public String getEstudoDetalhado() {
		return estudoDetalhado;
	}

	public void setEstudoDetalhado(String estudoDetalhado) {
		this.estudoDetalhado = estudoDetalhado;
	}
	
	
	
	
	
	
}

