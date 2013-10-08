package dao;

import modelo.Parasitologico;

public class ParasitologicoJPADAO extends GenericJPADAO<Parasitologico> implements
		ParasitologicoDAO {
	public ParasitologicoJPADAO() {
		this.persistentClass = Parasitologico.class;
	}
}
