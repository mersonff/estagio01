package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import modelo.Internamento;
import modelo.Paciente;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.InternamentoDAO;
import dao.InternamentoJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class InternamentoBean extends AbstractBean {
	private Internamento internamento;
	private List<Internamento> internamentos;
	private List<Internamento> filteredInternamentos;
	//Alterado por David Costa
	private String[] leito;// = { "1", "2", "..." };
	//

	public InternamentoBean() {
		this.setInternamento(new Internamento());
		this.setInternamentos(new ArrayList<Internamento>());
		findAll();
	}

	public void cadastrar() {
		InternamentoDAO operDAO = new InternamentoJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.internamento.getPaciente().getNumeroSus());
		if (p != null) {
			this.internamento.setData(new Date());
			//operDAO.save(this.internamento);
			
			//Adicionado por David Costa
			operDAO.put(this.internamento);
			//
			
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.internamento = new Internamento();
		} else {
			displayErrorMessageToUser("Paciente não cadastrado: Por favor, cadastre o paciente e tente novamente.");
		}
	}

	public void excluir() {
		InternamentoDAO operDAO = new InternamentoJPADAO();
		operDAO.delete(this.internamento);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.internamentos = operDAO.find();
	}

	public void findAll() {
		InternamentoDAO operDAO = new InternamentoJPADAO();
		this.internamentos = operDAO.find();
		
		//Adicionado por David Costa
		TiposBean tipos = new TiposBean();
		this.leito = tipos.getTiposLeitos().toArray(new String[tipos.getTiposLeitos().size()]);
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

	public Internamento getInternamento() {
		return internamento;
	}

	public void setInternamento(Internamento internamento) {
		this.internamento = internamento;
	}

	public List<Internamento> getInternamentos() {
		return internamentos;
	}

	public void setInternamentos(List<Internamento> internamentos) {
		this.internamentos = internamentos;
	}

	public List<Internamento> getFilteredInternamentos() {
		return filteredInternamentos;
	}

	public void setFilteredInternamentos(
			List<Internamento> filteredInternamentos) {
		this.filteredInternamentos = filteredInternamentos;
	}

	public String[] getLeito() {
		return leito;
	}

	public void setLeito(String[] leito) {
		this.leito = leito;
	}

}
