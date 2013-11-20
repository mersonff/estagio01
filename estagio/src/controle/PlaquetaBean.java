package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Plaqueta;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.PlaquetaDAO;
import dao.PlaquetaJPADAO;

@ManagedBean
public class PlaquetaBean extends AbstractBean {
	private Plaqueta plaqueta;
	private List<Plaqueta> plaquetas;
	private List<Plaqueta> plaquetaEmEspera;
	private List<Plaqueta> plaquetaEmAberto;
	private List<Plaqueta> filteredPlaquetas;

	public PlaquetaBean() {
		this.setPlaqueta(new Plaqueta());
		this.setPlaquetas(new ArrayList<Plaqueta>());
		pesquisarTodos();
	}

	public void agendar() {
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.plaqueta.getPaciente().getNumeroSus());
		if (p != null) {
			this.plaqueta.setStatus("Em espera");
			operDAO.save(this.plaqueta);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.plaqueta = new Plaqueta();
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
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		this.plaqueta.setStatus("Em espera");
		operDAO.save(this.plaqueta);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void cadastrar() {
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		this.plaqueta.setDataPedido(new Date());
		this.plaqueta.setStatus("Em aberto");
		operDAO.save(this.plaqueta);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void atualizar() {
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		this.plaqueta.setStatus("Concluído");
		this.plaqueta.setDataEntrega(new Date());
		operDAO.save(this.plaqueta);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void pesquisarTodos() {
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		this.plaquetas = operDAO.find();
	}

	public void excluir() {
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		operDAO.delete(this.plaqueta);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.plaquetas = operDAO.find();

	}

	public void find() {
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.plaqueta.getPaciente().getNumeroSus());
		if (p != null) {
			displayInfoMessageToUser("Paciente encontrado.");
		} else {
			displayErrorMessageToUser("Paciente não encontrado. Por favor, realize o cadastro do paciente.");
		}
	}

	public Plaqueta getPlaqueta() {
		return plaqueta;
	}

	public void setPlaqueta(Plaqueta plaqueta) {
		this.plaqueta = plaqueta;
	}

	public List<Plaqueta> getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(List<Plaqueta> plaquetas) {
		this.plaquetas = plaquetas;
	}

	public List<Plaqueta> getFilteredPlaquetas() {
		return filteredPlaquetas;
	}

	public void setFilteredPlaquetas(
			List<Plaqueta> filteredPlaquetas) {
		this.filteredPlaquetas = filteredPlaquetas;
	}

	public List<Plaqueta> getPlaquetaEmEspera() {
		List<Plaqueta> temp = new ArrayList<Plaqueta>();
		for (Plaqueta b : plaquetas) {
			if (b.getStatus().equals("Em espera"))
				temp.add(b);
		}
		plaquetaEmEspera = temp;
		return plaquetaEmEspera;
	}

	public void setPlaquetaEmEspera(List<Plaqueta> plaquetaEmEspera) {
		this.plaquetaEmEspera = plaquetaEmEspera;
	}

	public List<Plaqueta> getPlaquetaEmAberto() {
		List<Plaqueta> temp = new ArrayList<Plaqueta>();
		for (Plaqueta b : plaquetas) {
			if (b.getStatus().equals("Em aberto"))
				temp.add(b);
		}
		plaquetaEmAberto = temp;
		return plaquetaEmAberto;
	}

	public void setPlaquetaEmAberto(List<Plaqueta> plaquetaEmAberto) {
		this.plaquetaEmAberto = plaquetaEmAberto;
	}

}
