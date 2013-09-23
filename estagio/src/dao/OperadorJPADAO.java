package dao;

import modelo.Operador;

public class OperadorJPADAO extends GenericJPADAO<Operador> implements OperadorDAO{
	
	public OperadorJPADAO(){
		this.persistentClass = Operador.class;
	}
	
}	
