package dao;

import javax.persistence.EntityManager;

import modelo.Baciloscopia;

public class BaciloscopiaJPADAO extends GenericJPADAO<Baciloscopia> implements
		BaciloscopiaDAO {

	EntityManager em;

	public BaciloscopiaJPADAO() {
		this.persistentClass = Baciloscopia.class;
	}

}
