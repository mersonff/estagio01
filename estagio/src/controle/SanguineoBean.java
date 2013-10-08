package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Sanguineo;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.SanguineoDAO;
import dao.SanguineoJPADAO;

@ManagedBean
public class SanguineoBean extends AbstractBean {
	private Sanguineo sanguineo;
	private List<Sanguineo> sanguineos;

	public SanguineoBean() {
		this.setSanguineo(new Sanguineo());
		this.setSanguineos(new ArrayList<Sanguineo>());
		pesquisarTodos();
	}

	public void cadastrar() {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.sanguineo.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.sanguineo);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		this.sanguineos = operDAO.find();
	}

	public void excluir(Sanguineo sanguineo) {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		operDAO.delete(sanguineo);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public Sanguineo getSanguineo() {
		return sanguineo;
	}

	public void setSanguineo(Sanguineo sanguineo) {
		this.sanguineo = sanguineo;
	}

	public List<Sanguineo> getSanguineos() {
		return sanguineos;
	}

	public void setSanguineos(List<Sanguineo> sanguineos) {
		this.sanguineos = sanguineos;
	}

}
