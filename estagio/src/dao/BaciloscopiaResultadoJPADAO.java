package dao;

import modelo.BaciloscopiaResultado;

public class BaciloscopiaResultadoJPADAO extends GenericJPADAO<BaciloscopiaResultado> implements
		BaciloscopiaResultadoDAO {
	public BaciloscopiaResultadoJPADAO() {
		this.persistentClass = BaciloscopiaResultado.class;
	}
}
