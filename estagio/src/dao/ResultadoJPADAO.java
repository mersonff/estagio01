package dao;

import modelo.Resultado;

public class ResultadoJPADAO extends GenericJPADAO<Resultado> implements ResultadoDAO {

	public ResultadoJPADAO() {
		this.persistentClass = Resultado.class;
	}

}
