package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Urina;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.UrinaDAO;
import dao.UrinaJPADAO;

@ManagedBean
public class UrinaBean extends AbstractBean {
	private Urina urina;
	private List<Urina> urinas;
	private List<Urina> urinaEmEspera;
	private List<Urina> urinaEmAberto;
	private List<Urina> filteredUrinas;
	private String[] elementosAnormais = { "Proteína", "Glicose", "Acetona",
			"Acetoacético", "Sais Biliares", "Pig Biliares", "Urobilinogênio",
			"Hemoglobina" };

	public UrinaBean() {
		this.setUrina(new Urina());
		this.setUrinas(new ArrayList<Urina>());
		pesquisarTodos();
	}

	public void agendar() {
		UrinaDAO operDAO = new UrinaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.urina.getPaciente().getNumeroSus());
		if (p != null) {
			this.urina.setStatus("Em espera");
			operDAO.save(this.urina);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.urina = new Urina();
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
		UrinaDAO operDAO = new UrinaJPADAO();
		this.urina.setStatus("Em espera");
		operDAO.save(this.urina);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void cadastrar() {
		UrinaDAO operDAO = new UrinaJPADAO();
		this.urina.setDataPedido(new Date());
		this.urina.setStatus("Em aberto");
		operDAO.save(this.urina);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void atualizar() {
		UrinaDAO operDAO = new UrinaJPADAO();
		this.urina.setStatus("Concluído");
		this.urina.setDataEntrega(new Date());
		operDAO.save(this.urina);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void pesquisarTodos() {
		UrinaDAO operDAO = new UrinaJPADAO();
		this.urinas = operDAO.find();
	}

	public void excluir() {
		UrinaDAO operDAO = new UrinaJPADAO();
		operDAO.delete(this.urina);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.urinas = operDAO.find();

	}

	public void find() {
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.urina.getPaciente().getNumeroSus());
		if (p != null) {
			displayInfoMessageToUser("Paciente encontrado.");
		} else {
			displayErrorMessageToUser("Paciente não encontrado. Por favor, realize o cadastro do paciente.");
		}
	}

	public Urina getUrina() {
		return urina;
	}

	public void setUrina(Urina urina) {
		this.urina = urina;
	}

	public List<Urina> getUrinas() {
		return urinas;
	}

	public void setUrinas(List<Urina> urinas) {
		this.urinas = urinas;
	}

	public List<Urina> getFilteredUrinas() {
		return filteredUrinas;
	}

	public void setFilteredUrinas(List<Urina> filteredUrinas) {
		this.filteredUrinas = filteredUrinas;
	}

	public List<Urina> getUrinaEmEspera() {
		List<Urina> temp = new ArrayList<Urina>();
		for (Urina b : urinas) {
			if (b.getStatus().equals("Em espera"))
				temp.add(b);
		}
		urinaEmEspera = temp;
		return urinaEmEspera;
	}

	public void setUrinaEmEspera(List<Urina> urinaEmEspera) {
		this.urinaEmEspera = urinaEmEspera;
	}

	public List<Urina> getUrinaEmAberto() {
		List<Urina> temp = new ArrayList<Urina>();
		for (Urina b : urinas) {
			if (b.getStatus().equals("Em aberto"))
				temp.add(b);
		}
		urinaEmAberto = temp;
		return urinaEmAberto;
	}

	public void setUrinaEmAberto(List<Urina> urinaEmAberto) {
		this.urinaEmAberto = urinaEmAberto;
	}

	public String[] getElementosAnormais() {
		return elementosAnormais;
	}

	public void setElementosAnormais(String[] elementosAnormais) {
		this.elementosAnormais = elementosAnormais;
	}

}
