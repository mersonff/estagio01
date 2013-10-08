package dao;

import modelo.Plaqueta;

public class PlaquetaJPADAO extends GenericJPADAO<Plaqueta> implements
		PlaquetaDAO {
	public PlaquetaJPADAO() {
		this.persistentClass = Plaqueta.class;
	}
}
