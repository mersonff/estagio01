package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.BioquimicaResultado;
import modelo.Exame;
import dao.BioquimicaResultadoDAO;
import dao.BioquimicaResultadoJPADAO;
import dao.ExameDAO;
import dao.ExameJPADAO;

@ManagedBean
public class BioquimicaResultadoBean extends AbstractBean {
	private BioquimicaResultado resultado;
	private List<BioquimicaResultado> resultados;
	private List<BioquimicaResultado> resultadosFiltrados;

	private final static String[] status;
	static {
		status = new String[2];
		status[0] = "Em aberto";
		status[1] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public BioquimicaResultadoBean() {
		this.setBioquimicaResultado(new BioquimicaResultado());
		this.setBioquimicaResultados(new ArrayList<BioquimicaResultado>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);
	}

	public void cadastrar() {
		BioquimicaResultadoDAO operDAO = new BioquimicaResultadoJPADAO();
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
		BioquimicaResultadoDAO operDAO = new BioquimicaResultadoJPADAO();
		this.resultados = operDAO.find();
	}

	public void excluir(BioquimicaResultado resultado) {
		BioquimicaResultadoDAO operDAO = new BioquimicaResultadoJPADAO();
		operDAO.delete(resultado);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public BioquimicaResultado getBioquimicaResultado() {
		return resultado;
	}

	public void setBioquimicaResultado(BioquimicaResultado resultado) {
		this.resultado = resultado;
	}

	public List<BioquimicaResultado> getBioquimicaResultados() {
		return resultados;
	}

	public void setBioquimicaResultados(List<BioquimicaResultado> resultados) {
		this.resultados = resultados;
	}

	public List<BioquimicaResultado> getBioquimicaResultadosFiltrados() {
		return resultadosFiltrados;
	}

	public void setBioquimicaResultadosFiltrados(List<BioquimicaResultado> resultadosFiltrados) {
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
