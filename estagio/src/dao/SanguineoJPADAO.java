package dao;

import modelo.Sanguineo;

public class SanguineoJPADAO extends GenericJPADAO<Sanguineo> implements
		SanguineoDAO {

	private static final long serialVersionUID = 1L;

	public SanguineoJPADAO() {
		this.persistentClass = Sanguineo.class;
	}
}
