package dao;

import modelo.Hemograma;

public class HemogramaJPADAO extends GenericJPADAO<Hemograma> implements
		HemogramaDAO {
	public HemogramaJPADAO() {
		this.persistentClass = Hemograma.class;
	}
}
