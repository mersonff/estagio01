package modelo;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Urina extends Exame {
	// Dados do Pedido
	private String leito;

	// Dados do Resultado
	private String volume;
	private String cor;
	private String aspecto;
	private double densidade;
	private double ph;

	@ElementCollection
	private List<String> elementosAnormais;

	private double cilindros;
	private double hemacias;
	private double leucocitos;
	private double celulas;

	private String estudoDetalhado;

	public Urina() {
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

	public double getDensidade() {
		return densidade;
	}

	public void setDensidade(double densidade) {
		this.densidade = densidade;
	}

	public double getPh() {
		return ph;
	}

	public void setPh(double ph) {
		this.ph = ph;
	}

	public List<String> getElementosAnormais() {
		return elementosAnormais;
	}

	public void setElementosAnormais(List<String> elementosAnormais) {
		this.elementosAnormais = elementosAnormais;
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
