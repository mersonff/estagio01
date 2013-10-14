package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idResultado")
public class PlaquetaResultado extends Resultado {
	private double hemoglobina;
	private double hematocitos;
	private double plaquetas;

	public double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public double getHematocitos() {
		return hematocitos;
	}

	public void setHematocitos(double hematocitos) {
		this.hematocitos = hematocitos;
	}

	public double getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(double plaquetas) {
		this.plaquetas = plaquetas;
	}

}
