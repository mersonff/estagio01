package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idResultado")
public class ParasitologicoResultado extends Resultado {
	private String metodo;

	private boolean ascaris;
	private boolean ancilostomideo;
	private boolean trichuris;
	private boolean enterobius;
	private boolean strongiloides;
	private boolean taenia;
	private boolean schistosoma;
	private boolean nana;
	private boolean diminuta;
	private boolean histolitica;
	private boolean coli;
	private boolean iodamoeba;
	private boolean endolimax;
	private boolean trichomonas;
	private boolean chilomati;
	private boolean giardia;
	private boolean balantid;
	private boolean isopora;

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public boolean isAscaris() {
		return ascaris;
	}

	public void setAscaris(boolean ascaris) {
		this.ascaris = ascaris;
	}

	public boolean isAncilostomideo() {
		return ancilostomideo;
	}

	public void setAncilostomideo(boolean ancilostomideo) {
		this.ancilostomideo = ancilostomideo;
	}

	public boolean isTrichuris() {
		return trichuris;
	}

	public void setTrichuris(boolean trichuris) {
		this.trichuris = trichuris;
	}

	public boolean isEnterobius() {
		return enterobius;
	}

	public void setEnterobius(boolean enterobius) {
		this.enterobius = enterobius;
	}

	public boolean isStrongiloides() {
		return strongiloides;
	}

	public void setStrongiloides(boolean strongiloides) {
		this.strongiloides = strongiloides;
	}

	public boolean isTaenia() {
		return taenia;
	}

	public void setTaenia(boolean taenia) {
		this.taenia = taenia;
	}

	public boolean isSchistosoma() {
		return schistosoma;
	}

	public void setSchistosoma(boolean schistosoma) {
		this.schistosoma = schistosoma;
	}

	public boolean isNana() {
		return nana;
	}

	public void setNana(boolean nana) {
		this.nana = nana;
	}

	public boolean isDiminuta() {
		return diminuta;
	}

	public void setDiminuta(boolean diminuta) {
		this.diminuta = diminuta;
	}

	public boolean isHistolitica() {
		return histolitica;
	}

	public void setHistolitica(boolean histolitica) {
		this.histolitica = histolitica;
	}

	public boolean isColi() {
		return coli;
	}

	public void setColi(boolean coli) {
		this.coli = coli;
	}

	public boolean isIodamoeba() {
		return iodamoeba;
	}

	public void setIodamoeba(boolean iodamoeba) {
		this.iodamoeba = iodamoeba;
	}

	public boolean isEndolimax() {
		return endolimax;
	}

	public void setEndolimax(boolean endolimax) {
		this.endolimax = endolimax;
	}

	public boolean isTrichomonas() {
		return trichomonas;
	}

	public void setTrichomonas(boolean trichomonas) {
		this.trichomonas = trichomonas;
	}

	public boolean isChilomati() {
		return chilomati;
	}

	public void setChilomati(boolean chilomati) {
		this.chilomati = chilomati;
	}

	public boolean isGiardia() {
		return giardia;
	}

	public void setGiardia(boolean giardia) {
		this.giardia = giardia;
	}

	public boolean isBalantid() {
		return balantid;
	}

	public void setBalantid(boolean balantid) {
		this.balantid = balantid;
	}

	public boolean isIsopora() {
		return isopora;
	}

	public void setIsopora(boolean isopora) {
		this.isopora = isopora;
	}

}
