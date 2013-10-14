package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.Exame;
import modelo.PlaquetaResultado;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PlaquetaResultadoDAO;
import dao.PlaquetaResultadoJPADAO;

@ManagedBean
public class PlaquetaResultadoBean extends AbstractBean {
	private PlaquetaResultado resultado;
	private List<PlaquetaResultado> resultados;
	private List<PlaquetaResultado> resultadosFiltrados;

	private final static String[] status;
	static {
		status = new String[2];
		status[0] = "Em aberto";
		status[1] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public PlaquetaResultadoBean() {
		this.setPlaquetaResultado(new PlaquetaResultado());
		this.setPlaquetaResultados(new ArrayList<PlaquetaResultado>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);
	}

	public void cadastrar() {
		PlaquetaResultadoDAO operDAO = new PlaquetaResultadoJPADAO();
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
		PlaquetaResultadoDAO operDAO = new PlaquetaResultadoJPADAO();
		this.resultados = operDAO.find();
	}

	public void excluir(PlaquetaResultado resultado) {
		PlaquetaResultadoDAO operDAO = new PlaquetaResultadoJPADAO();
		operDAO.delete(resultado);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public PlaquetaResultado getPlaquetaResultado() {
		return resultado;
	}

	public void setPlaquetaResultado(PlaquetaResultado resultado) {
		this.resultado = resultado;
	}

	public List<PlaquetaResultado> getPlaquetaResultados() {
		return resultados;
	}

	public void setPlaquetaResultados(List<PlaquetaResultado> resultados) {
		this.resultados = resultados;
	}

	public List<PlaquetaResultado> getPlaquetaResultadosFiltrados() {
		return resultadosFiltrados;
	}

	public void setPlaquetaResultadosFiltrados(List<PlaquetaResultado> resultadosFiltrados) {
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
