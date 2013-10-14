package dao;

import modelo.UrinaResultado;

public class UrinaResultadoJPADAO extends GenericJPADAO<UrinaResultado> implements
		UrinaResultadoDAO {
	public UrinaResultadoJPADAO() {
		this.persistentClass = UrinaResultado.class;
	}
}
