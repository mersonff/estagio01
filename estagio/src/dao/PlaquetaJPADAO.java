package dao;

import modelo.Plaqueta;

public class PlaquetaJPADAO extends GenericJPADAO<Plaqueta> implements
		PlaquetaDAO {

	private static final long serialVersionUID = 1L;

	public PlaquetaJPADAO() {
		this.persistentClass = Plaqueta.class;
	}
}
