package dao;

import modelo.PlaquetaResultado;

public class PlaquetaResultadoJPADAO extends GenericJPADAO<PlaquetaResultado> implements
		PlaquetaResultadoDAO {
	public PlaquetaResultadoJPADAO() {
		this.persistentClass = PlaquetaResultado.class;
	}
}
