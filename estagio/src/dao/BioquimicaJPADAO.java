package dao;

import modelo.Bioquimica;

public class BioquimicaJPADAO extends GenericJPADAO<Bioquimica> implements
		BioquimicaDAO {

	private static final long serialVersionUID = 1L;

	public BioquimicaJPADAO() {
		this.persistentClass = Bioquimica.class;
	}
}
