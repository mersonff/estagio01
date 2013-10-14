package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.Exame;
import modelo.ParasitologicoResultado;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.ParasitologicoResultadoDAO;
import dao.ParasitologicoResultadoJPADAO;

@ManagedBean
public class ParasitologicoResultadoBean extends AbstractBean {
	private ParasitologicoResultado resultado;
	private List<ParasitologicoResultado> resultados;
	private List<ParasitologicoResultado> resultadosFiltrados;

	private final static String[] status;
	static {
		status = new String[2];
		status[0] = "Em aberto";
		status[1] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public ParasitologicoResultadoBean() {
		this.setParasitologicoResultado(new ParasitologicoResultado());
		this.setParasitologicoResultados(new ArrayList<ParasitologicoResultado>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);
	}

	public void cadastrar() {
		ParasitologicoResultadoDAO operDAO = new ParasitologicoResultadoJPADAO();
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
		ParasitologicoResultadoDAO operDAO = new ParasitologicoResultadoJPADAO();
		this.resultados = operDAO.find();
	}

	public void excluir(ParasitologicoResultado resultado) {
		ParasitologicoResultadoDAO operDAO = new ParasitologicoResultadoJPADAO();
		operDAO.delete(resultado);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public ParasitologicoResultado getParasitologicoResultado() {
		return resultado;
	}

	public void setParasitologicoResultado(ParasitologicoResultado resultado) {
		this.resultado = resultado;
	}

	public List<ParasitologicoResultado> getParasitologicoResultados() {
		return resultados;
	}

	public void setParasitologicoResultados(List<ParasitologicoResultado> resultados) {
		this.resultados = resultados;
	}

	public List<ParasitologicoResultado> getParasitologicoResultadosFiltrados() {
		return resultadosFiltrados;
	}

	public void setParasitologicoResultadosFiltrados(List<ParasitologicoResultado> resultadosFiltrados) {
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
