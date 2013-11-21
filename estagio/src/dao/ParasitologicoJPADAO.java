package dao;

import modelo.Parasitologico;

public class ParasitologicoJPADAO extends GenericJPADAO<Parasitologico>
		implements ParasitologicoDAO {

	private static final long serialVersionUID = 1L;

	public ParasitologicoJPADAO() {
		this.persistentClass = Parasitologico.class;
	}
}
