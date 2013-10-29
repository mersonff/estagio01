package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
@ManagedBean
public class PacienteBean extends AbstractBean{
	
	private Paciente paciente;
	private List<Paciente> pacientes;
	private List<Paciente> pacientesFiltrados;
	
	public PacienteBean(){
		this.setPaciente(new Paciente());
		this.setPacientes(new ArrayList<Paciente>());
	}
	
	public void cadastrar(){
		PacienteDAO pacienteDAO = new PacienteJPADAO();
		Paciente p = pacienteDAO.find(this.paciente.getNumeroSus());
		if(p==null){
		pacienteDAO.save(this.paciente);
		displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayErrorMessageToUser("Número do SUS já cadastrado: Já existe um paciente com esse número de SUS cadastrado!");
		}
	}
	
	public void atualizar(){
		PacienteDAO pacienteDAO = new PacienteJPADAO();
		pacienteDAO.save(this.paciente);
		displayInfoMessageToUser("Atualizado com sucesso!");
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

	public List<Paciente> getPacientesFiltrados() {
		return pacientesFiltrados;
	}

	public void setPacientesFiltrados(List<Paciente> pacientesFiltrados) {
		this.pacientesFiltrados = pacientesFiltrados;
	}

}
