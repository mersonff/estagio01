package dao;

import modelo.Urina;

public class UrinaJPADAO extends GenericJPADAO<Urina> implements
		UrinaDAO {
	public UrinaJPADAO() {
		this.persistentClass = Urina.class;
	}
}
