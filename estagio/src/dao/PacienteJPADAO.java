package dao;

import modelo.Paciente;

public class PacienteJPADAO extends GenericJPADAO<Paciente> implements PacienteDAO{

	public PacienteJPADAO(){
		this.persistentClass = Paciente.class;
	}

}
