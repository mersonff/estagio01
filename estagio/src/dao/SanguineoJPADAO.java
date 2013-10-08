package dao;

import modelo.Sanguineo;

public class SanguineoJPADAO extends GenericJPADAO<Sanguineo> implements
		SanguineoDAO {
	public SanguineoJPADAO() {
		this.persistentClass = Sanguineo.class;
	}
}
