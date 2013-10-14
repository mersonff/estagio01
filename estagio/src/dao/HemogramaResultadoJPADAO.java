package dao;

import modelo.HemogramaResultado;

public class HemogramaResultadoJPADAO extends GenericJPADAO<HemogramaResultado> implements
		HemogramaResultadoDAO {
	public HemogramaResultadoJPADAO() {
		this.persistentClass = HemogramaResultado.class;
	}
}
