package dao;

import modelo.Operador;

public class OperadorJPADAO extends GenericJPADAO<Operador> implements
		OperadorDAO {

	private static final long serialVersionUID = 1L;

	public OperadorJPADAO() {
		this.persistentClass = Operador.class;
	}

}
