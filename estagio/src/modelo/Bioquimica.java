package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Bioquimica extends Exame{
	
	private String leito;
	
	public Bioquimica(){
		setNomeTipo("Bioquímica");
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}
	
	
	
	
}

