package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Bioquimica;
import modelo.Paciente;
import dao.BioquimicaDAO;
import dao.BioquimicaJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class BioquimicaBean extends AbstractBean {
	private Bioquimica bioquimica;
	private List<Bioquimica> bioquimicas;
	private List<Bioquimica> filteredBioquimicas;

	public BioquimicaBean() {
		this.setBioquimica(new Bioquimica());
		this.setBioquimicas(new ArrayList<Bioquimica>());
		pesquisarTodos();
	}

	public void cadastrar() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.bioquimica.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.bioquimica);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayErrorMessageToUser("Paciente não cadastrado: Por favor, cadastre o paciente e tente novamente.");
		}
		
	}

	public void cadastrarResultado() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		this.bioquimica.setStatus("Concluído");
		operDAO.save(this.bioquimica);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void pesquisarTodos() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		this.bioquimicas = operDAO.find();
	}

	public void excluir() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		operDAO.delete(this.bioquimica);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.bioquimicas = operDAO.find();

	}

	public Bioquimica getBioquimica() {
		return bioquimica;
	}

	public void setBioquimica(Bioquimica bioquimica) {
		this.bioquimica = bioquimica;
	}

	public List<Bioquimica> getBioquimicas() {
		return bioquimicas;
	}

	public void setBioquimicas(List<Bioquimica> bioquimicas) {
		this.bioquimicas = bioquimicas;
	}

	public List<Bioquimica> getFilteredBioquimicas() {
		return filteredBioquimicas;
	}

	public void setFilteredBioquimicas(
			List<Bioquimica> filteredBioquimicas) {
		this.filteredBioquimicas = filteredBioquimicas;
	}

}
