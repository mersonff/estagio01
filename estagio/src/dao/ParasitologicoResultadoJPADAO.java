package dao;

import modelo.ParasitologicoResultado;

public class ParasitologicoResultadoJPADAO extends GenericJPADAO<ParasitologicoResultado> implements
		ParasitologicoResultadoDAO {
	public ParasitologicoResultadoJPADAO() {
		this.persistentClass = ParasitologicoResultado.class;
	}
}
