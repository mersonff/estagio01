package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.Exame;
import modelo.HemogramaResultado;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.HemogramaResultadoDAO;
import dao.HemogramaResultadoJPADAO;

@ManagedBean
public class HemogramaResultadoBean extends AbstractBean {
	private HemogramaResultado resultado;
	private List<HemogramaResultado> resultados;
	private List<HemogramaResultado> resultadosFiltrados;

	private final static String[] status;
	static {
		status = new String[2];
		status[0] = "Em aberto";
		status[1] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public HemogramaResultadoBean() {
		this.setHemogramaResultado(new HemogramaResultado());
		this.setHemogramaResultados(new ArrayList<HemogramaResultado>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);
	}

	public void cadastrar() {
		HemogramaResultadoDAO operDAO = new HemogramaResultadoJPADAO();
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
		HemogramaResultadoDAO operDAO = new HemogramaResultadoJPADAO();
		this.resultados = operDAO.find();
	}

	public void excluir(HemogramaResultado resultado) {
		HemogramaResultadoDAO operDAO = new HemogramaResultadoJPADAO();
		operDAO.delete(resultado);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public HemogramaResultado getHemogramaResultado() {
		return resultado;
	}

	public void setHemogramaResultado(HemogramaResultado resultado) {
		this.resultado = resultado;
	}

	public List<HemogramaResultado> getHemogramaResultados() {
		return resultados;
	}

	public void setHemogramaResultados(List<HemogramaResultado> resultados) {
		this.resultados = resultados;
	}

	public List<HemogramaResultado> getHemogramaResultadosFiltrados() {
		return resultadosFiltrados;
	}

	public void setHemogramaResultadosFiltrados(List<HemogramaResultado> resultadosFiltrados) {
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
