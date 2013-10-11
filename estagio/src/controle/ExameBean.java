package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.Exame;
import modelo.Paciente;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class ExameBean extends AbstractBean {
	private Exame exame;
	private List<Exame> exames;
	private List<Exame> examesFiltrados;

	private final static String[] status;
	static {
		status = new String[2];
		status[0] = "Em aberto";
		status[1] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public ExameBean() {
		this.setExame(new Exame());
		this.setExames(new ArrayList<Exame>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);
	}

	public void cadastrar() {
		ExameDAO operDAO = new ExameJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.exame.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.exame);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		ExameDAO operDAO = new ExameJPADAO();
		this.exames = operDAO.find();
	}

	public void excluir(Exame exame) {
		ExameDAO operDAO = new ExameJPADAO();
		operDAO.delete(exame);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public List<Exame> getExamesFiltrados() {
		return examesFiltrados;
	}

	public void setExamesFiltrados(List<Exame> examesFiltrados) {
		this.examesFiltrados = examesFiltrados;
	}

	private SelectItem[] createFilterOptions(String[] data) {
		SelectItem[] options = new SelectItem[data.length + 1];

		options[0] = new SelectItem("", "Selecione");
		for (int i = 0; i < data.length; i++) {
			options[i + 1] = new SelectItem(data[i], data[i]);
		}

		return options;
	}

	public SelectItem[] getStatusOptions() {
		return statusOptions;
	}

}
