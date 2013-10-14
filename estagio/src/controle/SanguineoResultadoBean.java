package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.Exame;
import modelo.SanguineoResultado;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.SanguineoResultadoDAO;
import dao.SanguineoResultadoJPADAO;

@ManagedBean
public class SanguineoResultadoBean extends AbstractBean {
	private SanguineoResultado resultado;
	private List<SanguineoResultado> resultados;
	private List<SanguineoResultado> resultadosFiltrados;

	private final static String[] status;
	static {
		status = new String[2];
		status[0] = "Em aberto";
		status[1] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public SanguineoResultadoBean() {
		this.setSanguineoResultado(new SanguineoResultado());
		this.setSanguineoResultados(new ArrayList<SanguineoResultado>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);
	}

	public void cadastrar() {
		SanguineoResultadoDAO operDAO = new SanguineoResultadoJPADAO();
		ExameDAO eDAO = new ExameJPADAO();
		Exame e = eDAO.find(this.resultado.getIdResultado());
		if (e != null) {
			operDAO.save(this.resultado);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		SanguineoResultadoDAO operDAO = new SanguineoResultadoJPADAO();
		this.resultados = operDAO.find();
	}

	public void excluir(SanguineoResultado resultado) {
		SanguineoResultadoDAO operDAO = new SanguineoResultadoJPADAO();
		operDAO.delete(resultado);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public SanguineoResultado getSanguineoResultado() {
		return resultado;
	}

	public void setSanguineoResultado(SanguineoResultado resultado) {
		this.resultado = resultado;
	}

	public List<SanguineoResultado> getSanguineoResultados() {
		return resultados;
	}

	public void setSanguineoResultados(List<SanguineoResultado> resultados) {
		this.resultados = resultados;
	}

	public List<SanguineoResultado> getSanguineoResultadosFiltrados() {
		return resultadosFiltrados;
	}

	public void setSanguineoResultadosFiltrados(List<SanguineoResultado> resultadosFiltrados) {
		this.resultadosFiltrados = resultadosFiltrados;
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
