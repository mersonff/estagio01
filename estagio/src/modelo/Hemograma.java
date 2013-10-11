package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "idExame")
public class Hemograma extends Exame{
	
	private String leito;
	
	public Hemograma(){
		setNomeTipo("Hemograma");
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}
	
	
	
	
}

