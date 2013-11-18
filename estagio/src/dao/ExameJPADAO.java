package dao;

import java.util.Date;
import java.util.List;

import modelo.Exame;

public class ExameJPADAO extends GenericJPADAO<Exame> implements ExameDAO {

	public ExameJPADAO() {
		this.persistentClass = Exame.class;
	}

	public List<Exame> quantPacientesAtendidos(Date inicio, Date fim) {
		return this.getEm().createNamedQuery("Exame.QuantPacientesAtendidos").setParameter("dataInicio", inicio).setParameter("dataFim", fim).getResultList();
	}

	public List<Exame> quantGeralExame(Date inicio, Date fim) {
		return this.getEm().createNamedQuery("Exame.quantGeralExame").setParameter("dataInicio", inicio).setParameter("dataFim", fim).getResultList();
	}

	public List<Exame> quantTipoExame(Date inicio, Date fim, String nome) {
		return this.getEm().createNamedQuery("Exame.quantTipoExame").setParameter("dataInicio", inicio).setParameter("dataFim", fim).setParameter("nomeTipo", nome).getResultList();
	}

}
