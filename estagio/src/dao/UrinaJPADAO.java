package dao;

import modelo.Urina;

public class UrinaJPADAO extends GenericJPADAO<Urina> implements UrinaDAO {

	private static final long serialVersionUID = 1L;

	public UrinaJPADAO() {
		this.persistentClass = Urina.class;
	}
}
