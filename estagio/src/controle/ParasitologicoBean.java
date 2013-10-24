package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Parasitologico;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.ParasitologicoDAO;
import dao.ParasitologicoJPADAO;

@ManagedBean
public class ParasitologicoBean extends AbstractBean {
	private Parasitologico parasitologico;
	private List<Parasitologico> parasitologicos;

	public ParasitologicoBean() {
		this.setParasitologico(new Parasitologico());
		this.setParasitologicos(new ArrayList<Parasitologico>());
		pesquisarTodos();
	}

	public void cadastrar() {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.parasitologico.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.parasitologico);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		this.parasitologicos = operDAO.find();
	}

	public void excluir(Parasitologico parasitologico) {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		operDAO.delete(parasitologico);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public Parasitologico getParasitologico() {
		return parasitologico;
	}

	public void setParasitologico(Parasitologico parasitologico) {
		this.parasitologico = parasitologico;
	}

	public List<Parasitologico> getParasitologicos() {
		return parasitologicos;
	}

	public void setParasitologicos(List<Parasitologico> parasitologicos) {
		this.parasitologicos = parasitologicos;
	}

}
