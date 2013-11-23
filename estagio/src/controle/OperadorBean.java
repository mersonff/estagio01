package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.Operador;
import dao.OperadorDAO;
import dao.OperadorJPADAO;

@ManagedBean
public class OperadorBean extends AbstractBean {

	private Operador operador;
	private Operador ativo;
	private List<Operador> operadores;
	private List<Operador> filteredOperadores;
	private String senhaAtual;
	private String novaSenha;
	private String confirmaNovaSenha;

	public OperadorBean() {
		this.setOperadores(new ArrayList<Operador>());
		this.setOperador(new Operador());
		findAll();
	}

	public void cadastrar() {
		OperadorDAO operadorDAO = new OperadorJPADAO();
		Operador p = operadorDAO.find(this.operador.getLogin());
		if (p == null) {
			operadorDAO.save(this.operador);
			displayInfoMessageToUser("Cadastrado com sucesso!");
			this.operador = new Operador();
		} else {
			displayErrorMessageToUser("Login indisponível: Esse Login já está sendo usado.");
		}
	}

	public void atualizar() {
		OperadorDAO operDAO = new OperadorJPADAO();
		operDAO.save(this.ativo);
		displayInfoMessageToUser("Atualizado com Sucesso!");
	}

	public void editar() {
		OperadorDAO operDAO = new OperadorJPADAO();
		operDAO.save(this.operador);
		displayInfoMessageToUser("Atualizado com Sucesso!");
		this.operadores = operDAO.find();
	}

	public void alterarSenha() {
		OperadorDAO operDAO = new OperadorJPADAO();
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
		OperadorDAO operDAO = new OperadorJPADAO();
		operDAO.delete(this.operador);
		displayInfoMessageToUser("Excluido com sucesso!");
		this.operadores = operDAO.find();
	}

	public void findAll() {
		OperadorDAO operDAO = new OperadorJPADAO();
		this.operadores = operDAO.find();
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public List<Operador> getOperadores() {
		return operadores;
	}

	public void setOperadores(List<Operador> operadores) {
		this.operadores = operadores;
	}

	public List<Operador> getFilteredOperadores() {
		return filteredOperadores;
	}

	public void setFilteredOperadores(List<Operador> filteredOperadores) {
		this.filteredOperadores = filteredOperadores;
	}

	public Operador getAtivo() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		Operador temp = new Operador();
		OperadorDAO pDAO = new OperadorJPADAO();
		temp = pDAO.find(sessao.getAttribute("login"));
		ativo = temp;
		return ativo;
	}

	public void setAtivo(Operador ativo) {
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
