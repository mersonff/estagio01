package dao;

import modelo.Tipos;

public class TiposJPADAO extends GenericJPADAO<Tipos> implements TiposDAO {

	private static final long serialVersionUID = 1L;

	public TiposJPADAO() {
		this.persistentClass = Tipos.class;
	}
}
