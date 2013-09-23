package dao;

import modelo.TipoDeExame;

public class TipoDeExameJPADAO extends GenericJPADAO<TipoDeExame> implements TipoDeExameDAO{
	
	public TipoDeExameJPADAO(){
		this.persistentClass = TipoDeExame.class;
	}
	
}
