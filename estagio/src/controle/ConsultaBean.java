package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import modelo.Consulta;
import modelo.Paciente;
import dao.ConsultaDAO;
import dao.ConsultaJPADAO;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class ConsultaBean extends AbstractBean {
	private Consulta consulta;
	private List<Consulta> consultas;
	private List<Consulta> filteredConsultas;
	private String[] tipoAtendimento = { "XXXXXXX", "XXXXXXX", "XXXXXXX",
			"XXXXXXX", "XXXXXXX", "XXXXXXX", "XXXXXXX" };
	private String[] tipoConsulta = { "Primeira Consulta", "Retorno" };

	public ConsultaBean() {
		this.setConsulta(new Consulta());
		this.setConsultas(new ArrayList<Consulta>());
		findAll();
	}

	public void cadastrar() {
		ConsultaDAO operDAO = new ConsultaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.consulta.getPaciente().getNumeroSus());
		if (p != null) {
			this.consulta.setData(new Date());
			operDAO.save(this.consulta);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.consulta = new Consulta();
		} else {
			displayErrorMessageToUser("Paciente não cadastrado: Por favor, cadastre o paciente e tente novamente.");
		}
	}
	
	public void excluir() {
		ConsultaDAO operDAO = new ConsultaJPADAO();
		operDAO.delete(this.consulta);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.consultas = operDAO.find();
	}

	public void findAll() {
		ConsultaDAO operDAO = new ConsultaJPADAO();
		this.consultas = operDAO.find();
	}

	public List<String> complete(String query) {
		List<String> results = new ArrayList<String>();
		ExameDAO exameDAO = new ExameJPADAO();
		results = exameDAO.autoComplete(query);
		Set<String> resultadoSemRepeticao = new HashSet<String>();
		for (String nome : results) {
			resultadoSemRepeticao.add(nome);
		}
		results.clear();
		for (String nome : resultadoSemRepeticao) {
			results.add(nome);
		}
		return results;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Consulta> getFilteredConsultas() {
		return filteredConsultas;
	}

	public String[] getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(String[] tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public String[] getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String[] tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public void setFilteredConsultas(List<Consulta> filteredConsultas) {
		this.filteredConsultas = filteredConsultas;
	}

}
