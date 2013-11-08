package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Parasitologico;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.ParasitologicoDAO;
import dao.ParasitologicoJPADAO;

@ManagedBean
public class ParasitologicoBean extends AbstractBean {
	private Parasitologico parasitologico;
	private List<Parasitologico> parasitologicos;
	private List<Parasitologico> parasitologicoEmEspera;
	private List<Parasitologico> parasitologicoEmAberto;
	private List<Parasitologico> filteredParasitologicos;
	private String[] metodos = { "Baerman", "Simples", "Hamatoxilina",
			"Seriado" };
	private String[] ovos = { "Ascaris Lumbric�ides", "Ancilostomideo",
			"Trichuris Trichiura", "Enterobius Vermiculares",
			"Strongiloides Larvas", "Taenia SP", "Schistosoma Mansonu",
			"Hymenolepis Nana", "Hymenolepis Diminuta" };
	private String[] protozoarios = { "Entamoeba Histolitica",
			"Entamoeba Coli", "Iodamoeba Butchili", "Endolimax Nana",
			"Trichomonas Hominis", "Chilomati Mesnili", "Giarda Lamblia",
			"Balantio II Coli", "Isopora Beli" };

	public ParasitologicoBean() {
		this.setParasitologico(new Parasitologico());
		this.setParasitologicos(new ArrayList<Parasitologico>());
		pesquisarTodos();
	}

	public void agendar() {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO
				.find(this.parasitologico.getPaciente().getNumeroSus());
		if (p != null) {
			this.parasitologico.setStatus("Em espera");
			operDAO.save(this.parasitologico);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.parasitologico = new Parasitologico();
		} else {
			displayErrorMessageToUser("Paciente n�o cadastrado: Por favor, cadastre o paciente e tente novamente.");
		}

	}

	public void remarcar() {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		this.parasitologico.setStatus("Em espera");
		operDAO.save(this.parasitologico);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void cadastrar() {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		this.parasitologico.setDataPedido(new Date());
		this.parasitologico.setStatus("Em aberto");
		operDAO.save(this.parasitologico);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void atualizar() {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		this.parasitologico.setStatus("Conclu�do");
		this.parasitologico.setDataEntrega(new Date());
		operDAO.save(this.parasitologico);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void pesquisarTodos() {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		this.parasitologicos = operDAO.find();
	}

	public void excluir() {
		ParasitologicoDAO operDAO = new ParasitologicoJPADAO();
		operDAO.delete(this.parasitologico);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.parasitologicos = operDAO.find();

	}

	public void find() {
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO
				.find(this.parasitologico.getPaciente().getNumeroSus());
		if (p != null) {
			displayInfoMessageToUser("Paciente encontrado.");
		} else {
			displayErrorMessageToUser("Paciente n�o encontrado. Por favor, realize o cadastro do paciente.");
		}
	}

	public Parasitologico getParasitologico() {
		return parasitologico;
	}

	public void setParasitologico(Parasitologico parasitologico) {
		this.parasitologico = parasitologico;
	}

	public List<Parasitologico> getParasitologicos() {
		return parasitologicos;
	}

	public void setParasitologicos(List<Parasitologico> parasitologicos) {
		this.parasitologicos = parasitologicos;
	}

	public List<Parasitologico> getFilteredParasitologicos() {
		return filteredParasitologicos;
	}

	public void setFilteredParasitologicos(
			List<Parasitologico> filteredParasitologicos) {
		this.filteredParasitologicos = filteredParasitologicos;
	}

	public List<Parasitologico> getParasitologicoEmEspera() {
		List<Parasitologico> temp = new ArrayList<Parasitologico>();
		for (Parasitologico b : parasitologicos) {
			if (b.getStatus().equals("Em espera"))
				temp.add(b);
		}
		parasitologicoEmEspera = temp;
		return parasitologicoEmEspera;
	}

	public void setParasitologicoEmEspera(
			List<Parasitologico> parasitologicoEmEspera) {
		this.parasitologicoEmEspera = parasitologicoEmEspera;
	}

	public List<Parasitologico> getParasitologicoEmAberto() {
		List<Parasitologico> temp = new ArrayList<Parasitologico>();
		for (Parasitologico b : parasitologicos) {
			if (b.getStatus().equals("Em aberto"))
				temp.add(b);
		}
		parasitologicoEmAberto = temp;
		return parasitologicoEmAberto;
	}

	public void setParasitologicoEmAberto(
			List<Parasitologico> parasitologicoEmAberto) {
		this.parasitologicoEmAberto = parasitologicoEmAberto;
	}

	public String[] getMetodos() {
		return metodos;
	}

	public void setMetodos(String[] metodos) {
		this.metodos = metodos;
	}

	public String[] getOvos() {
		return ovos;
	}

	public void setOvos(String[] ovos) {
		this.ovos = ovos;
	}

	public String[] getProtozoarios() {
		return protozoarios;
	}

	public void setProtozoarios(String[] protozoarios) {
		this.protozoarios = protozoarios;
	}

}
