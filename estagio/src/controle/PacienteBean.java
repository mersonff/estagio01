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
		Paciente p = pacienteDAO.find(this.paciente.getNumeroSus());
		if(p==null){
		pacienteDAO.save(this.paciente);
		displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayErrorMessageToUser("N�mero do SUS j� cadastrado: J� existe um paciente com esse n�mero de SUS cadastrado!");
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

}
