package dao;

import modelo.Baciloscopia;

public class BaciloscopiaJPADAO extends GenericJPADAO<Baciloscopia> implements
		BaciloscopiaDAO {

	private static final long serialVersionUID = 1L;

	public BaciloscopiaJPADAO() {
		this.persistentClass = Baciloscopia.class;
	}

}
