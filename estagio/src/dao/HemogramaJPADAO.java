package dao;

import modelo.Hemograma;

public class HemogramaJPADAO extends GenericJPADAO<Hemograma> implements
		HemogramaDAO {

	private static final long serialVersionUID = 1L;

	public HemogramaJPADAO() {
		this.persistentClass = Hemograma.class;
	}
}
