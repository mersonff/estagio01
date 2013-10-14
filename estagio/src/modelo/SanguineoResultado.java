package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idResultado")
public class SanguineoResultado extends Resultado {
	private String abo;
	private String fotarRH;

	public String getAbo() {
		return abo;
	}

	public void setAbo(String abo) {
		this.abo = abo;
	}

	public String getFotarRH() {
		return fotarRH;
	}

	public void setFotarRH(String fotarRH) {
		this.fotarRH = fotarRH;
	}

}
