package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.AdministradorDAO;
import dao.AdministradorJPADAO;

import modelo.Administrador;

@ManagedBean
public class AdminBean  extends AbstractBean{
	
	private Administrador administrador;
	private Administrador ativo;
	private String novaSenha;
	
	public AdminBean(){
		this.administrador = new Administrador();
	}
	
	public void atualizar(){
		AdministradorDAO adminDAO = new AdministradorJPADAO();
		adminDAO.save(this.ativo);
		displayInfoMessageToUser("Atualizado com sucesso!");
	}
	
	public void alterarSenha(){
		AdministradorDAO adminDAO = new AdministradorJPADAO();
		this.ativo.setSenha(this.novaSenha);
		adminDAO.save(this.ativo);
		displayInfoMessageToUser("Atualizada com sucesso!");
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public Administrador getAtivo() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Administrador temp = new Administrador();
		AdministradorDAO adminDAO = new AdministradorJPADAO();
		temp =adminDAO.find(sessao.getAttribute("login"));
		this.ativo = temp;
		return ativo;
	}

	public void setAtivo(Administrador ativo) {
		this.ativo = ativo;
	}

}
