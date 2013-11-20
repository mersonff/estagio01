package dao;

import java.util.Date;
import java.util.List;

import modelo.Exame;

public interface ExameDAO extends GenericDAO<Exame>{
	
	public List<String> autoComplete(String solicitante);
	
	public List<Exame> quantGeralExame(Date inicio, Date fim);
	
	public List<Exame> quantTipoExame(Date inicio, Date fim, String nome);

}
