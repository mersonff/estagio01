package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Sanguineo;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.SanguineoDAO;
import dao.SanguineoJPADAO;

@ManagedBean
public class SanguineoBean extends AbstractBean {
	private Sanguineo sanguineo;
	private List<Sanguineo> sanguineos;
	private List<Sanguineo> sanguineoEmEspera;
	private List<Sanguineo> sanguineoEmAberto;
	private List<Sanguineo> filteredSanguineos;

	public SanguineoBean() {
		this.setSanguineo(new Sanguineo());
		this.setSanguineos(new ArrayList<Sanguineo>());
		pesquisarTodos();
	}

	public void agendar() {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.sanguineo.getPaciente().getNumeroSus());
		if (p != null) {
			this.sanguineo.setStatus("Em espera");
			operDAO.save(this.sanguineo);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.sanguineo = new Sanguineo();
		} else {
			displayErrorMessageToUser("Paciente não cadastrado: Por favor, cadastre o paciente e tente novamente.");
		}

	}
	
	public List<String> complete(String query){
		 List<String> results = new ArrayList<String>();  
		 ExameDAO exameDAO = new ExameJPADAO();
		 results = exameDAO.autoComplete(query);
		 Set<String> resultadoSemRepeticao = new HashSet<String>();
		 for(String nome: results){
			 resultadoSemRepeticao.add(nome);
		 }
		 results.clear();
		 for(String nome: resultadoSemRepeticao){
			 results.add(nome);
		 }
	     return results; 
	}

	public void remarcar() {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		this.sanguineo.setStatus("Em espera");
		operDAO.save(this.sanguineo);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void cadastrar() {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		this.sanguineo.setDataPedido(new Date());
		this.sanguineo.setStatus("Em aberto");
		operDAO.save(this.sanguineo);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void atualizar() {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		this.sanguineo.setStatus("Concluído");
		this.sanguineo.setDataEntrega(new Date());
		operDAO.save(this.sanguineo);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void pesquisarTodos() {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		this.sanguineos = operDAO.find();
	}

	public void excluir() {
		SanguineoDAO operDAO = new SanguineoJPADAO();
		operDAO.delete(this.sanguineo);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.sanguineos = operDAO.find();

	}

	public void find() {
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.sanguineo.getPaciente().getNumeroSus());
		if (p != null) {
			displayInfoMessageToUser("Paciente encontrado.");
		} else {
			displayErrorMessageToUser("Paciente não encontrado. Por favor, realize o cadastro do paciente.");
		}
	}

	public Sanguineo getSanguineo() {
		return sanguineo;
	}

	public void setSanguineo(Sanguineo sanguineo) {
		this.sanguineo = sanguineo;
	}

	public List<Sanguineo> getSanguineos() {
		return sanguineos;
	}

	public void setSanguineos(List<Sanguineo> sanguineos) {
		this.sanguineos = sanguineos;
	}

	public List<Sanguineo> getFilteredSanguineos() {
		return filteredSanguineos;
	}

	public void setFilteredSanguineos(
			List<Sanguineo> filteredSanguineos) {
		this.filteredSanguineos = filteredSanguineos;
	}

	public List<Sanguineo> getSanguineoEmEspera() {
		List<Sanguineo> temp = new ArrayList<Sanguineo>();
		for (Sanguineo b : sanguineos) {
			if (b.getStatus().equals("Em espera"))
				temp.add(b);
		}
		sanguineoEmEspera = temp;
		return sanguineoEmEspera;
	}

	public void setSanguineoEmEspera(List<Sanguineo> sanguineoEmEspera) {
		this.sanguineoEmEspera = sanguineoEmEspera;
	}

	public List<Sanguineo> getSanguineoEmAberto() {
		List<Sanguineo> temp = new ArrayList<Sanguineo>();
		for (Sanguineo b : sanguineos) {
			if (b.getStatus().equals("Em aberto"))
				temp.add(b);
		}
		sanguineoEmAberto = temp;
		return sanguineoEmAberto;
	}

	public void setSanguineoEmAberto(List<Sanguineo> sanguineoEmAberto) {
		this.sanguineoEmAberto = sanguineoEmAberto;
	}

}
