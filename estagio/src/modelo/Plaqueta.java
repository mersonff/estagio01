package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Plaqueta extends Exame{
	//Dados do Pedido
	private String leito;
	
	//Dados do Resultado;
	private double hemoglobina;
	private double hematocrito;
	private double plaquetas;
	
	public Plaqueta(){
		setNomeTipo("Hb / Ht com Plaquetas");
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}

	public double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public double getHematocrito() {
		return hematocrito;
	}

	public void setHematocrito(double hematocrito) {
		this.hematocrito = hematocrito;
	}

	public double getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(double plaquetas) {
		this.plaquetas = plaquetas;
	}
	
}

