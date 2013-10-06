package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Hemograma;
import modelo.Paciente;
import dao.HemogramaDAO;
import dao.HemogramaJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class HemogramaBean extends AbstractBean {
	private Hemograma hemograma;
	private List<Hemograma> hemogramas;

	public HemogramaBean() {
		this.setHemograma(new Hemograma());
		this.setHemogramas(new ArrayList<Hemograma>());
		pesquisarTodos();
	}

	public void cadastrar() {
		HemogramaDAO operDAO = new HemogramaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.hemograma.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.hemograma);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		HemogramaDAO operDAO = new HemogramaJPADAO();
		this.hemogramas = operDAO.find();
	}

	public void excluir(Hemograma hemo) {
		HemogramaDAO operDAO = new HemogramaJPADAO();
		operDAO.delete(hemo);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public Hemograma getHemograma() {
		return hemograma;
	}

	public void setHemograma(Hemograma Hemograma) {
		this.hemograma = Hemograma;
	}

	public List<Hemograma> getHemogramas() {
		return hemogramas;
	}

	public void setHemogramas(List<Hemograma> hemogramas) {
		this.hemogramas = hemogramas;
	}
}
