package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Bioquimica;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.BioquimicaDAO;
import dao.BioquimicaJPADAO;

@ManagedBean
public class BioquimicaBean extends AbstractBean {
	private Bioquimica bioquimica;
	private List<Bioquimica> bioquimicas;

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
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		this.bioquimicas = operDAO.find();
	}

	public void excluir(Bioquimica bioquimica) {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		operDAO.delete(bioquimica);
		displayInfoMessageToUser("Excluido com sucesso!");
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

}
