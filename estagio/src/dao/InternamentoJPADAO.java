package dao;

import modelo.Internamento;

public class InternamentoJPADAO extends GenericJPADAO<Internamento> implements
		InternamentoDAO {

	private static final long serialVersionUID = 1L;

	public InternamentoJPADAO() {
		this.persistentClass = Internamento.class;
	}

}
