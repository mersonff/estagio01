package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Baciloscopia;
import modelo.Exame;
import modelo.Paciente;
import dao.BaciloscopiaDAO;
import dao.BaciloscopiaJPADAO;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class PacienteBean extends AbstractBean {

	private Paciente paciente;
	private List<Paciente> pacientes;
	private List<Paciente> filteredPacientes;

	public PacienteBean() {
		this.setPaciente(new Paciente());
		this.setPacientes(new ArrayList<Paciente>());
		findAll();
	}

	public void cadastrar() {
		PacienteDAO pacienteDAO = new PacienteJPADAO();
		Paciente p = pacienteDAO.find(this.paciente.getNumeroSus());
		if (p == null) {
			pacienteDAO.save(this.paciente);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.paciente = new Paciente();
		} else {
			displayErrorMessageToUser("Número do SUS já cadastrado.");
		}
	}

	public void atualizar() {
		PacienteDAO pacienteDAO = new PacienteJPADAO();
		pacienteDAO.save(this.paciente);
		displayInfoMessageToUser("Atualizado com sucesso!");
	}

	public void excluir() {
		PacienteDAO operDAO = new PacienteJPADAO();
		ExameDAO eDAO = new ExameJPADAO();
		List<Exame> exames = eDAO.find();
		for (Exame e : exames) {
			if (e.getPaciente().getNumeroSus() == this.paciente.getNumeroSus())
				eDAO.delete(e);
		}
		operDAO.delete(this.paciente);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.pacientes = operDAO.find();
	}

	public void findAll() {
		PacienteDAO operDAO = new PacienteJPADAO();
		this.pacientes = operDAO.find();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Paciente> getFilteredPacientes() {
		return filteredPacientes;
	}

	public void setFilteredPacientes(List<Paciente> filteredPacientes) {
		this.filteredPacientes = filteredPacientes;
	}
}
