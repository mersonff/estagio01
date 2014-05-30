package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;


import dao.TiposDAO;
import dao.TiposJPADAO;


import modelo.Consulta;
import modelo.Tipos;

//Criado por David Costa
@ManagedBean
public class TiposBean extends AbstractBean{
	private Tipos tipo;
	private List<Tipos> tipos;
	private List<Consulta> filteredTipos;
	private List<String> tiposAreaAtendimento;
	private List<String> tiposAtendimento;
	private List<String> tiposLeitos;
	private List<String> tiposConsultas;
	
	public TiposBean() {
		this.setTipo(new Tipos());
		this.setTipos(new ArrayList<Tipos>());
		this.setTiposAreaAtendimento(new ArrayList<String>());
		this.setTiposAtendimento(new ArrayList<String>());
		this.setTiposLeitos(new ArrayList<String>());
		this.setTiposConsultas(new ArrayList<String>());
		findAll();
	}
	
	public void cadastrar(){
		TiposDAO operDAO = new TiposJPADAO();
		
		if (this.tipo.getTipoAtendimento().equals("") && this.tipo.getTipoAreaAtendimento().equals("") &&
				this.tipo.getTipoConsulta().equals("") && this.tipo.getTipoLeito().equals("")) {
				displayErrorMessageToUser("Tipo não cadastrado: Por favor, preencha pelo menos um dos campos.");
		} else {
			operDAO.save(this.tipo);
			displayInfoMessageToUser("Tipo(s) Cadastrado(s) com sucesso!");
		}
	}
	
	public void excluir(){
		TiposDAO operDAO = new TiposJPADAO();
		operDAO.delete(this.tipo);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.tipos = operDAO.find();
	}
	
	public void findAll() {
		TiposDAO operDAO = new TiposJPADAO();
		this.tipos = operDAO.find();
		
		for(Tipos tipo : this.tipos){
			if(!tipo.getTipoAreaAtendimento().equals("")){
				this.tiposAreaAtendimento.add(tipo.getTipoAreaAtendimento());
			}
			if(!tipo.getTipoAtendimento().equals("")){
				this.tiposAtendimento.add(tipo.getTipoAtendimento());
			}
			if(!tipo.getTipoLeito().equals("")){
				this.tiposLeitos.add(tipo.getTipoLeito());
			}
			if(!tipo.getTipoConsulta().equals("")){
				this.tiposConsultas.add(tipo.getTipoConsulta());
			}
		}
	}
	
	public Tipos getTipo() {
		return tipo;
	}
	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}
	public List<Tipos> getTipos() {
		return tipos;
	}
	public void setTipos(List<Tipos> tipos) {
		this.tipos = tipos;
	}

	public List<String> getTiposAreaAtendimento() {
		return tiposAreaAtendimento;
	}

	public void setTiposAreaAtendimento(List<String> tiposAreaAtendimento) {
		this.tiposAreaAtendimento = tiposAreaAtendimento;
	}

	public List<String> getTiposAtendimento() {
		return tiposAtendimento;
	}

	public void setTiposAtendimento(List<String> tiposAtendimento) {
		this.tiposAtendimento = tiposAtendimento;
	}

	public List<String> getTiposLeitos() {
		return tiposLeitos;
	}

	public void setTiposLeitos(List<String> tiposLeitos) {
		this.tiposLeitos = tiposLeitos;
	}

	public List<String> getTiposConsultas() {
		return tiposConsultas;
	}

	public void setTiposConsultas(List<String> tiposConsultas) {
		this.tiposConsultas = tiposConsultas;
	}

	public List<Consulta> getFilteredTipos() {
		return filteredTipos;
	}

	public void setFilteredTipos(List<Consulta> filteredTipos) {
		this.filteredTipos = filteredTipos;
	}
	
	
	
}
