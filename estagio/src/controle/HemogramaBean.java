package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import modelo.Hemograma;
import modelo.Paciente;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.HemogramaDAO;
import dao.HemogramaJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class HemogramaBean extends AbstractBean {
	private Hemograma hemograma;
	private List<Hemograma> hemogramas;
	private List<Hemograma> hemogramaEmEspera;
	private List<Hemograma> hemogramaEmAberto;
	private List<Hemograma> filteredHemogramas;
	private String[] tipoHemacias = { "Normais", "Hipocrômicas",
			"Anisocrômicas", "Microcíticas", "Anisocíticas", "Macrocíticas",
			"Poiquilocíticas" };
	private String[] tipoPlaquetas = { "Normais", "Aumentadas", "Diminuidas" };
	private String[] tipoLinfocitos = { "Com atipias", "Sem atipias" };
	private String[] tipoGranulacoes = { "Aus�ncia", "Presença" };
	private String[] tipoEritroblastos = { "Basófilos", "Policromatófilos",
			"Ortocromáticos" };

	public HemogramaBean() {
		this.setHemograma(new Hemograma());
		this.setHemogramas(new ArrayList<Hemograma>());
		findAll();
	}

	public void agendar() {
		HemogramaDAO operDAO = new HemogramaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.hemograma.getPaciente().getNumeroSus());
		if (p != null) {
			this.hemograma.setStatus("Em espera");
			operDAO.save(this.hemograma);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.hemograma = new Hemograma();
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
		HemogramaDAO operDAO = new HemogramaJPADAO();
		this.hemograma.setStatus("Em espera");
		operDAO.save(this.hemograma);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void cadastrar() {
		HemogramaDAO operDAO = new HemogramaJPADAO();
		this.hemograma.setDataPedido(new Date());
		this.hemograma.setStatus("Em aberto");
		operDAO.save(this.hemograma);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void atualizar() {
		HemogramaDAO operDAO = new HemogramaJPADAO();
		this.hemograma.setStatus("Concluído");
		this.hemograma.setDataEntrega(new Date());
		operDAO.save(this.hemograma);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void findAll() {
		HemogramaDAO operDAO = new HemogramaJPADAO();
		this.hemogramas = operDAO.find();
	}

	public void excluir() {
		HemogramaDAO operDAO = new HemogramaJPADAO();
		operDAO.delete(this.hemograma);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.hemogramas = operDAO.find();

	}

	public Hemograma getHemograma() {
		return hemograma;
	}

	public void setHemograma(Hemograma hemograma) {
		this.hemograma = hemograma;
	}

	public List<Hemograma> getHemogramas() {
		return hemogramas;
	}

	public void setHemogramas(List<Hemograma> hemogramas) {
		this.hemogramas = hemogramas;
	}

	public List<Hemograma> getFilteredHemogramas() {
		return filteredHemogramas;
	}

	public void setFilteredHemogramas(List<Hemograma> filteredHemogramas) {
		this.filteredHemogramas = filteredHemogramas;
	}

	public List<Hemograma> getHemogramaEmEspera() {
		List<Hemograma> temp = new ArrayList<Hemograma>();
		for (Hemograma b : hemogramas) {
			if (b.getStatus().equals("Em espera"))
				temp.add(b);
		}
		hemogramaEmEspera = temp;
		return hemogramaEmEspera;
	}

	public void setHemogramaEmEspera(List<Hemograma> hemogramaEmEspera) {
		this.hemogramaEmEspera = hemogramaEmEspera;
	}

	public List<Hemograma> getHemogramaEmAberto() {
		List<Hemograma> temp = new ArrayList<Hemograma>();
		for (Hemograma b : hemogramas) {
			if (b.getStatus().equals("Em aberto"))
				temp.add(b);
		}
		hemogramaEmAberto = temp;
		return hemogramaEmAberto;
	}

	public void setHemogramaEmAberto(List<Hemograma> hemogramaEmAberto) {
		this.hemogramaEmAberto = hemogramaEmAberto;
	}

	public String[] getTipoHemacias() {
		return tipoHemacias;
	}

	public void setTipoHemacias(String[] tipoHemacias) {
		this.tipoHemacias = tipoHemacias;
	}

	public String[] getTipoPlaquetas() {
		return tipoPlaquetas;
	}

	public void setTipoPlaquetas(String[] tipoPlaquetas) {
		this.tipoPlaquetas = tipoPlaquetas;
	}

	public String[] getTipoLinfocitos() {
		return tipoLinfocitos;
	}

	public void setTipoLinfocitos(String[] tipoLinfocitos) {
		this.tipoLinfocitos = tipoLinfocitos;
	}

	public String[] getTipoGranulacoes() {
		return tipoGranulacoes;
	}

	public void setTipoGranulacoes(String[] tipoGranulacoes) {
		this.tipoGranulacoes = tipoGranulacoes;
	}

	public String[] getTipoEritroblastos() {
		return tipoEritroblastos;
	}

	public void setTipoEritroblastos(String[] tipoEritroblastos) {
		this.tipoEritroblastos = tipoEritroblastos;
	}

}
