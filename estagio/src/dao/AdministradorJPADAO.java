package dao;

import modelo.Administrador;

public class AdministradorJPADAO extends GenericJPADAO<Administrador> implements AdministradorDAO {
	
	private static final long serialVersionUID = 1L;

	public AdministradorJPADAO(){
		this.persistentClass = Administrador.class;
	}

}
