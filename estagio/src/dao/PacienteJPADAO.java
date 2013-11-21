package dao;

import modelo.Paciente;

public class PacienteJPADAO extends GenericJPADAO<Paciente> implements
		PacienteDAO {

	private static final long serialVersionUID = 1L;

	public PacienteJPADAO() {
		this.persistentClass = Paciente.class;
	}

}
