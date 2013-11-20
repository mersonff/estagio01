package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import modelo.Bioquimica;
import modelo.Paciente;
import dao.BioquimicaDAO;
import dao.BioquimicaJPADAO;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class BioquimicaBean extends AbstractBean {
	private Bioquimica bioquimica;
	private List<Bioquimica> bioquimicas;
	private List<Bioquimica> bioquimicaEmEspera;
	private List<Bioquimica> bioquimicaEmAberto;
	private List<Bioquimica> filteredBioquimicas;

	public BioquimicaBean() {
		this.setBioquimica(new Bioquimica());
		this.setBioquimicas(new ArrayList<Bioquimica>());
		pesquisarTodos();
	}

	public void agendar() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.bioquimica.getPaciente().getNumeroSus());
		if (p != null) {
			this.bioquimica.setStatus("Em espera");
			operDAO.save(this.bioquimica);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.bioquimica = new Bioquimica();
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
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		this.bioquimica.setStatus("Em espera");
		operDAO.save(this.bioquimica);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void cadastrar() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		this.bioquimica.setDataPedido(new Date());
		this.bioquimica.setStatus("Em aberto");
		operDAO.save(this.bioquimica);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void atualizar() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		this.bioquimica.setStatus("Concluído");
		this.bioquimica.setDataEntrega(new Date());
		operDAO.save(this.bioquimica);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void pesquisarTodos() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		this.bioquimicas = operDAO.find();
	}

	public void excluir() {
		BioquimicaDAO operDAO = new BioquimicaJPADAO();
		operDAO.delete(this.bioquimica);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.bioquimicas = operDAO.find();

	}

	public void find() {
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.bioquimica.getPaciente().getNumeroSus());
		if (p != null) {
			displayInfoMessageToUser("Paciente encontrado.");
		} else {
			displayErrorMessageToUser("Paciente não encontrado. Por favor, realize o cadastro do paciente.");
		}
	}

	public Bioquimica getBioquimica() {
		return bioquimica;
	}

	public void setBioquimica(Bioquimica bioquimica) {
		this.bioquimica = bioquimica;
	}

	public List<Bioquimica> getBioquimicas() {
		return bioquimicas;
	}

	public void setBioquimicas(List<Bioquimica> bioquimicas) {
		this.bioquimicas = bioquimicas;
	}

	public List<Bioquimica> getFilteredBioquimicas() {
		return filteredBioquimicas;
	}

	public void setFilteredBioquimicas(
			List<Bioquimica> filteredBioquimicas) {
		this.filteredBioquimicas = filteredBioquimicas;
	}

	public List<Bioquimica> getBioquimicaEmEspera() {
		List<Bioquimica> temp = new ArrayList<Bioquimica>();
		for (Bioquimica b : bioquimicas) {
			if (b.getStatus().equals("Em espera"))
				temp.add(b);
		}
		bioquimicaEmEspera = temp;
		return bioquimicaEmEspera;
	}

	public void setBioquimicaEmEspera(List<Bioquimica> bioquimicaEmEspera) {
		this.bioquimicaEmEspera = bioquimicaEmEspera;
	}

	public List<Bioquimica> getBioquimicaEmAberto() {
		List<Bioquimica> temp = new ArrayList<Bioquimica>();
		for (Bioquimica b : bioquimicas) {
			if (b.getStatus().equals("Em aberto"))
				temp.add(b);
		}
		bioquimicaEmAberto = temp;
		return bioquimicaEmAberto;
	}

	public void setBioquimicaEmAberto(List<Bioquimica> bioquimicaEmAberto) {
		this.bioquimicaEmAberto = bioquimicaEmAberto;
	}

}
