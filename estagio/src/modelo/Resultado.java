package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idResultado;
	private String dataEntrega;

	public Resultado() {

	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public long getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(long idResultado) {
		this.idResultado = idResultado;
	}
	
}
