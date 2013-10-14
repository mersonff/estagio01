package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.BaciloscopiaResultado;
import modelo.Exame;
import dao.BaciloscopiaResultadoDAO;
import dao.BaciloscopiaResultadoJPADAO;
import dao.ExameDAO;
import dao.ExameJPADAO;

@ManagedBean
public class BaciloscopiaResultadoBean extends AbstractBean {
	private BaciloscopiaResultado resultado;
	private List<BaciloscopiaResultado> resultados;
	private List<BaciloscopiaResultado> resultadosFiltrados;

	private final static String[] status;
	static {
		status = new String[2];
		status[0] = "Em aberto";
		status[1] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public BaciloscopiaResultadoBean() {
		this.setBaciloscopiaResultado(new BaciloscopiaResultado());
		this.setBaciloscopiaResultados(new ArrayList<BaciloscopiaResultado>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);
	}

	public void cadastrar() {
		BaciloscopiaResultadoDAO operDAO = new BaciloscopiaResultadoJPADAO();
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
		BaciloscopiaResultadoDAO operDAO = new BaciloscopiaResultadoJPADAO();
		this.resultados = operDAO.find();
	}

	public void excluir(BaciloscopiaResultado resultado) {
		BaciloscopiaResultadoDAO operDAO = new BaciloscopiaResultadoJPADAO();
		operDAO.delete(resultado);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public BaciloscopiaResultado getBaciloscopiaResultado() {
		return resultado;
	}

	public void setBaciloscopiaResultado(BaciloscopiaResultado resultado) {
		this.resultado = resultado;
	}

	public List<BaciloscopiaResultado> getBaciloscopiaResultados() {
		return resultados;
	}

	public void setBaciloscopiaResultados(List<BaciloscopiaResultado> resultados) {
		this.resultados = resultados;
	}

	public List<BaciloscopiaResultado> getBaciloscopiaResultadosFiltrados() {
		return resultadosFiltrados;
	}

	public void setBaciloscopiaResultadosFiltrados(List<BaciloscopiaResultado> resultadosFiltrados) {
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
