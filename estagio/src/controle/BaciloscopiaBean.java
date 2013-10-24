package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Baciloscopia;
import modelo.Paciente;
import dao.BaciloscopiaDAO;
import dao.BaciloscopiaJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class BaciloscopiaBean extends AbstractBean {
	private Baciloscopia baciloscopia;
	private List<Baciloscopia> baciloscopias;
	private List<Baciloscopia> filteredBaciloscopias;
	private Baciloscopia selectedBaciloscopia;

	public BaciloscopiaBean() {
		this.setBaciloscopia(new Baciloscopia());
		this.setBaciloscopias(new ArrayList<Baciloscopia>());
		pesquisarTodos();
	}

	public void cadastrar() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.baciloscopia.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.baciloscopia);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayErrorMessageToUser("Paciente não cadastrado: Por favor, cadastre o paciente e tente novamente.");
		}
	}

	public void cadastrarResultado() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopia.setStatus("Concluído");
		operDAO.save(this.baciloscopia);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void pesquisarTodos() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopias = operDAO.find();
	}

	public void excluir(Baciloscopia bacil) {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		operDAO.delete(bacil);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public Baciloscopia getBaciloscopia() {
		return baciloscopia;
	}

	public void setBaciloscopia(Baciloscopia baciloscopia) {
		this.baciloscopia = baciloscopia;
	}

	public List<Baciloscopia> getBaciloscopias() {
		return baciloscopias;
	}

	public void setBaciloscopias(List<Baciloscopia> baciloscopias) {
		this.baciloscopias = baciloscopias;
	}

	public List<Baciloscopia> getFilteredBaciloscopias() {
		return filteredBaciloscopias;
	}

	public void setFilteredBaciloscopias(
			List<Baciloscopia> filteredBaciloscopias) {
		this.filteredBaciloscopias = filteredBaciloscopias;
	}

	public Baciloscopia getSelectedBaciloscopia() {
		return selectedBaciloscopia;
	}

	public void setSelectedBaciloscopia(Baciloscopia selectedBaciloscopia) {
		this.selectedBaciloscopia = selectedBaciloscopia;
	}

}
