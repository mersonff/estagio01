package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Sanguineo extends Exame{
	
	private String leito;
	
	public Sanguineo(){
		setNomeTipo("Sanguíneo");
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}
	
	
	
	
}

