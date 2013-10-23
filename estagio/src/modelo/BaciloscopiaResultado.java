package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idResultado")
public class BaciloscopiaResultado extends Resultado {
	private String aspectoDoEscarro;
	private boolean negativo;
	private boolean baar;
	private String positividade;
	private String observacoes;

	public String getAspectoDoEscarro() {
		return aspectoDoEscarro;
	}

	public void setAspectoDoEscarro(String aspectoDoEscarro) {
		this.aspectoDoEscarro = aspectoDoEscarro;
	}

	public boolean isNegativo() {
		return negativo;
	}

	public void setNegativo(boolean negativo) {
		this.negativo = negativo;
	}

	public boolean isBaar() {
		return baar;
	}

	public void setBaar(boolean baar) {
		this.baar = baar;
	}

	public String getPositividade() {
		return positividade;
	}

	public void setPositividade(String positividade) {
		this.positividade = positividade;
	}

	public String getObservações() {
		return observacoes;
	}

	public void setObservações(String observações) {
		this.observacoes = observações;
	}

}
