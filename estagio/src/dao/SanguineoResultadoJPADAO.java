package dao;

import modelo.SanguineoResultado;

public class SanguineoResultadoJPADAO extends GenericJPADAO<SanguineoResultado> implements
		SanguineoResultadoDAO {
	public SanguineoResultadoJPADAO() {
		this.persistentClass = SanguineoResultado.class;
	}
}
