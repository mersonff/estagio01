package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idResultado")
public class BioquimicaResultado extends Resultado {
	private double glicose;
	private double colesterol;
	private double triglicerides;
	private double ureia;
	private double creatina;
	private double acidoUrico;
	private double tgo;
	private double tgp;
	private double fosfatase;
	private double biliburrinaTotal;
	private double biliburrinaDireta;
	private double biliburrinaIndireta;
	private double proteinasTotais;
	private double albumina;
	private double amilase;
	private double aso;
	private double pcr;
	private double latex;
	private double vdrl;
	private double vhs;
	private double bhcg;
	private double ttgo;

	public double getGlicose() {
		return glicose;
	}

	public void setGlicose(double glicose) {
		this.glicose = glicose;
	}

	public double getColesterol() {
		return colesterol;
	}

	public void setColesterol(double colesterol) {
		this.colesterol = colesterol;
	}

	public double getTriglicerides() {
		return triglicerides;
	}

	public void setTriglicerides(double triglicerides) {
		this.triglicerides = triglicerides;
	}

	public double getUreia() {
		return ureia;
	}

	public void setUreia(double ureia) {
		this.ureia = ureia;
	}

	public double getCreatina() {
		return creatina;
	}

	public void setCreatina(double creatina) {
		this.creatina = creatina;
	}

	public double getAcidoUrico() {
		return acidoUrico;
	}

	public void setAcidoUrico(double acidoUrico) {
		this.acidoUrico = acidoUrico;
	}

	public double getTgo() {
		return tgo;
	}

	public void setTgo(double tgo) {
		this.tgo = tgo;
	}

	public double getTgp() {
		return tgp;
	}

	public void setTgp(double tgp) {
		this.tgp = tgp;
	}

	public double getFosfatase() {
		return fosfatase;
	}

	public void setFosfatase(double fosfatase) {
		this.fosfatase = fosfatase;
	}

	public double getBiliburrinaTotal() {
		return biliburrinaTotal;
	}

	public void setBiliburrinaTotal(double biliburrinaTotal) {
		this.biliburrinaTotal = biliburrinaTotal;
	}

	public double getBiliburrinaDireta() {
		return biliburrinaDireta;
	}

	public void setBiliburrinaDireta(double biliburrinaDireta) {
		this.biliburrinaDireta = biliburrinaDireta;
	}

	public double getBiliburrinaIndireta() {
		return biliburrinaIndireta;
	}

	public void setBiliburrinaIndireta(double biliburrinaIndireta) {
		this.biliburrinaIndireta = biliburrinaIndireta;
	}

	public double getProteinasTotais() {
		return proteinasTotais;
	}

	public void setProteinasTotais(double proteinasTotais) {
		this.proteinasTotais = proteinasTotais;
	}

	public double getAlbumina() {
		return albumina;
	}

	public void setAlbumina(double albumina) {
		this.albumina = albumina;
	}

	public double getAmilase() {
		return amilase;
	}

	public void setAmilase(double amilase) {
		this.amilase = amilase;
	}

	public double getAso() {
		return aso;
	}

	public void setAso(double aso) {
		this.aso = aso;
	}

	public double getPcr() {
		return pcr;
	}

	public void setPcr(double pcr) {
		this.pcr = pcr;
	}

	public double getLatex() {
		return latex;
	}

	public void setLatex(double latex) {
		this.latex = latex;
	}

	public double getVdrl() {
		return vdrl;
	}

	public void setVdrl(double vdrl) {
		this.vdrl = vdrl;
	}

	public double getVhs() {
		return vhs;
	}

	public void setVhs(double vhs) {
		this.vhs = vhs;
	}

	public double getBhcg() {
		return bhcg;
	}

	public void setBhcg(double bhcg) {
		this.bhcg = bhcg;
	}

	public double getTtgo() {
		return ttgo;
	}

	public void setTtgo(double ttgo) {
		this.ttgo = ttgo;
	}

}
