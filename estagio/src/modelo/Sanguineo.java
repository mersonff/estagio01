package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Sanguineo extends Exame {
	// Dados do Pedido
	private String leito;

	// Dados do Resultado
	private String abo;
	private String fotarRH;

	public Sanguineo() {
		setNomeTipo("Sanguíneo");
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}

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
