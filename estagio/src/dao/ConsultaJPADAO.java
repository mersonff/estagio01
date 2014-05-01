package dao;

import modelo.Consulta;

public class ConsultaJPADAO extends GenericJPADAO<Consulta> implements
		ConsultaDAO {

	private static final long serialVersionUID = 1L;

	public ConsultaJPADAO() {
		this.persistentClass = Consulta.class;
	}

}
