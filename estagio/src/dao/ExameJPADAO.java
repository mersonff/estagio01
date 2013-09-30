package dao;

import modelo.Exame;

public class ExameJPADAO extends GenericJPADAO<Exame> implements ExameDAO {

	public ExameJPADAO() {
		this.persistentClass = Exame.class;
	}

}
