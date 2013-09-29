package dao;

import modelo.Baciloscopia;

public class BaciloscopiaJPADAO extends GenericJPADAO<Baciloscopia> implements BaciloscopiaDAO{

	public BaciloscopiaJPADAO() {
		this.persistentClass = Baciloscopia.class;
	}
	
}
