package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.Atendente;
import dao.AtendenteDAO;
import dao.AtendenteJPADAO;

@ManagedBean
public class AtendenteBean extends AbstractBean {

	private Atendente atendente;
	private Atendente ativo;
	private List<Atendente> atendentees;
	private List<Atendente> filteredAtendentees;
	private String senhaAtual;
	private String novaSenha;
	private String confirmaNovaSenha;

	public AtendenteBean() {
		this.setAtendentees(new ArrayList<Atendente>());
		this.setAtendente(new Atendente());
		findAll();
	}

	public void cadastrar() {
		AtendenteDAO atendenteDAO = new AtendenteJPADAO();
		Atendente p = atendenteDAO.find(this.atendente.getLogin());
		if (p == null) {
			atendenteDAO.save(this.atendente);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.atendente = new Atendente();
		} else {
			displayErrorMessageToUser("Login indisponível: Esse Login já está sendo usado.");
		}
	}

	public void atualizar() {
		AtendenteDAO operDAO = new AtendenteJPADAO();
		operDAO.save(this.ativo);
		displayInfoMessageToUser("Atualizado com Sucesso!");
	}

	public void editar() {
		AtendenteDAO operDAO = new AtendenteJPADAO();
		operDAO.save(this.atendente);
		displayInfoMessageToUser("Atualizado com Sucesso!");
		this.atendentees = operDAO.find();
	}

	public void alterarSenha() {
		AtendenteDAO operDAO = new AtendenteJPADAO();
		if(this.ativo.getSenha().equals(this.senhaAtual)){
			if(this.novaSenha.equals(this.confirmaNovaSenha)){
				this.ativo.setSenha(this.novaSenha);
				operDAO.save(this.ativo);
				displayInfoMessageToUser("Atualizado com Sucesso!");
			}else{
				displayErrorMessageToUser("Erro na confirmação da senha!");
			}
		}else{
			displayErrorMessageToUser("Senha atual inválida!");
		}
		

	}

	public void excluir() {
		AtendenteDAO operDAO = new AtendenteJPADAO();
		operDAO.delete(this.atendente);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.atendentees = operDAO.find();
	}

	public void findAll() {
		AtendenteDAO operDAO = new AtendenteJPADAO();
		this.atendentees = operDAO.find();
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public List<Atendente> getAtendentees() {
		return atendentees;
	}

	public void setAtendentees(List<Atendente> atendentees) {
		this.atendentees = atendentees;
	}

	public List<Atendente> getFilteredAtendentees() {
		return filteredAtendentees;
	}

	public void setFilteredAtendentees(List<Atendente> filteredAtendentees) {
		this.filteredAtendentees = filteredAtendentees;
	}

	public Atendente getAtivo() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		Atendente temp = new Atendente();
		AtendenteDAO pDAO = new AtendenteJPADAO();
		temp = pDAO.find(sessao.getAttribute("login"));
		ativo = temp;
		return ativo;
	}

	public void setAtivo(Atendente ativo) {
		this.ativo = ativo;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmaNovaSenha() {
		return confirmaNovaSenha;
	}

	public void setConfirmaNovaSenha(String confirmaNovaSenha) {
		this.confirmaNovaSenha = confirmaNovaSenha;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

}
