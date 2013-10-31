package controle;

import java.util.ArrayList;
import java.util.Date;
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
	private String filtro;

	public BaciloscopiaBean() {
		this.setBaciloscopia(new Baciloscopia());
		this.setBaciloscopias(new ArrayList<Baciloscopia>());
		pesquisarTodos();
	}

	public void agendar() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.baciloscopia.getPaciente().getNumeroSus());
		if (p != null) {
			this.baciloscopia.setStatus("Em espera");
			operDAO.save(this.baciloscopia);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.baciloscopia = new Baciloscopia();
		} else {
			displayErrorMessageToUser("Paciente n�o cadastrado: Por favor, cadastre o paciente e tente novamente.");
		}

	}

	public void cadastrar() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopia.setDataPedido(new Date());
		this.baciloscopia.setStatus("Em aberto");
		operDAO.save(this.baciloscopia);
		displayInfoMessageToUser("Cadastrado com sucesso!");
		this.baciloscopia = new Baciloscopia();
	}

	public void atualizar() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopia.setStatus("Conclu�do");
		this.baciloscopia.setDataEntrega(new Date());
		operDAO.save(this.baciloscopia);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void pesquisarTodos() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopias = operDAO.find();
	}

	public void excluir() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		operDAO.delete(this.baciloscopia);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.baciloscopias = operDAO.find();

	}

	public void find() {
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.baciloscopia.getPaciente().getNumeroSus());
		if (p != null) {
			displayInfoMessageToUser("Paciente encontrado.");
		} else {
			displayErrorMessageToUser("Paciente n�o encontrado. Por favor, realize o cadastro do paciente.");
		}
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

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
