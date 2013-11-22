package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import modelo.Baciloscopia;
import modelo.Paciente;
import dao.BaciloscopiaDAO;
import dao.BaciloscopiaJPADAO;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class BaciloscopiaBean extends AbstractBean {
	private Baciloscopia baciloscopia;
	private List<Baciloscopia> baciloscopias;
	private List<Baciloscopia> baciloscopiaEmEspera;
	private List<Baciloscopia> baciloscopiaEmAberto;
	private List<Baciloscopia> filteredBaciloscopias;

	public BaciloscopiaBean() {
		this.setBaciloscopia(new Baciloscopia());
		this.setBaciloscopias(new ArrayList<Baciloscopia>());
		findAll();
	}

	public void agendar() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.baciloscopia.getPaciente().getNumeroSus());
		if (p != null) {
			this.baciloscopia.setStatus("Em espera");
			operDAO.save(this.baciloscopia);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.baciloscopia = new Baciloscopia();
		} else {
			displayErrorMessageToUser("Paciente não cadastrado: Por favor, cadastre o paciente e tente novamente.");
		}

	}

	public void remarcar() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopia.setStatus("Em espera");
		operDAO.save(this.baciloscopia);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void cadastrar() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopia.setDataPedido(new Date());
		this.baciloscopia.setStatus("Em aberto");
		operDAO.save(this.baciloscopia);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}

	public void atualizar() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopia.setStatus("Concluído");
		this.baciloscopia.setDataEntrega(new Date());
		operDAO.save(this.baciloscopia);
		displayInfoMessageToUser("Cadastrado com sucesso!");

	}

	public void excluir() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		operDAO.delete(this.baciloscopia);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.baciloscopias = operDAO.find();
	}

	public void findAll() {
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopias = operDAO.find();
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

	public Baciloscopia getBaciloscopia() {
		return baciloscopia;
	}

	public void setBaciloscopia(Baciloscopia baciloscopia) {
		this.baciloscopia = baciloscopia;
	}

	public List<Baciloscopia> getBaciloscopias() {
		return baciloscopias;
	}

	public void setBaciloscopias(List<Baciloscopia> baciloscopias) {
		this.baciloscopias = baciloscopias;
	}

	public List<Baciloscopia> getFilteredBaciloscopias() {
		return filteredBaciloscopias;
	}

	public void setFilteredBaciloscopias(
			List<Baciloscopia> filteredBaciloscopias) {
		this.filteredBaciloscopias = filteredBaciloscopias;
	}

	public List<Baciloscopia> getBaciloscopiaEmEspera() {
		List<Baciloscopia> temp = new ArrayList<Baciloscopia>();
		for (Baciloscopia b : baciloscopias) {
			if (b.getStatus().equals("Em espera"))
				temp.add(b);
		}
		baciloscopiaEmEspera = temp;
		return baciloscopiaEmEspera;
	}

	public void setBaciloscopiaEmEspera(List<Baciloscopia> baciloscopiaEmEspera) {
		this.baciloscopiaEmEspera = baciloscopiaEmEspera;
	}

	public List<Baciloscopia> getBaciloscopiaEmAberto() {
		List<Baciloscopia> temp = new ArrayList<Baciloscopia>();
		for (Baciloscopia b : baciloscopias) {
			if (b.getStatus().equals("Em aberto"))
				temp.add(b);
		}
		baciloscopiaEmAberto = temp;
		return baciloscopiaEmAberto;
	}

	public void setBaciloscopiaEmAberto(List<Baciloscopia> baciloscopiaEmAberto) {
		this.baciloscopiaEmAberto = baciloscopiaEmAberto;
	}

}
