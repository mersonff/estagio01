package dao;

import modelo.Atendente;

public class AtendenteJPADAO extends GenericJPADAO<Atendente> implements
		AtendenteDAO {

	private static final long serialVersionUID = 1L;

	public AtendenteJPADAO() {
		this.persistentClass = Atendente.class;
	}

}
