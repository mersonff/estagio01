package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.Exame;
import modelo.UrinaResultado;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.UrinaResultadoDAO;
import dao.UrinaResultadoJPADAO;

@ManagedBean
public class UrinaResultadoBean extends AbstractBean {
	private UrinaResultado resultado;
	private List<UrinaResultado> resultados;
	private List<UrinaResultado> resultadosFiltrados;

	private final static String[] status;
	static {
		status = new String[2];
		status[0] = "Em aberto";
		status[1] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public UrinaResultadoBean() {
		this.setUrinaResultado(new UrinaResultado());
		this.setUrinaResultados(new ArrayList<UrinaResultado>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);
	}

	public void cadastrar() {
		UrinaResultadoDAO operDAO = new UrinaResultadoJPADAO();
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
		UrinaResultadoDAO operDAO = new UrinaResultadoJPADAO();
		this.resultados = operDAO.find();
	}

	public void excluir(UrinaResultado resultado) {
		UrinaResultadoDAO operDAO = new UrinaResultadoJPADAO();
		operDAO.delete(resultado);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public UrinaResultado getUrinaResultado() {
		return resultado;
	}

	public void setUrinaResultado(UrinaResultado resultado) {
		this.resultado = resultado;
	}

	public List<UrinaResultado> getUrinaResultados() {
		return resultados;
	}

	public void setUrinaResultados(List<UrinaResultado> resultados) {
		this.resultados = resultados;
	}

	public List<UrinaResultado> getUrinaResultadosFiltrados() {
		return resultadosFiltrados;
	}

	public void setUrinaResultadosFiltrados(List<UrinaResultado> resultadosFiltrados) {
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
