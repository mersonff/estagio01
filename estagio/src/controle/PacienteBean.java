package controle;

import javax.faces.bean.ManagedBean;

import dao.PacienteDAO;
import dao.PacienteJPADAO;

import modelo.Paciente;
@ManagedBean
public class PacienteBean extends AbstractBean{
	
	private Paciente paciente;
	
	public PacienteBean(){
		this.setPaciente(new Paciente());
	}
	
	public void cadastrar(){
		PacienteDAO pacienteDAO = new PacienteJPADAO();
		pacienteDAO.save(this.paciente);
		displayInfoMessageToUser("Cadastrado com sucesso!");
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

}
