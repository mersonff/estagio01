package dao;

import modelo.BioquimicaResultado;

public class BioquimicaResultadoJPADAO extends
		GenericJPADAO<BioquimicaResultado> implements BioquimicaResultadoDAO {
	public BioquimicaResultadoJPADAO() {
		this.persistentClass = BioquimicaResultado.class;
	}
}
