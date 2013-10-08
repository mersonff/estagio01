package dao;

import modelo.Bioquimica;

public class BioquimicaJPADAO extends GenericJPADAO<Bioquimica> implements
		BioquimicaDAO {
	public BioquimicaJPADAO() {
		this.persistentClass = Bioquimica.class;
	}
}
