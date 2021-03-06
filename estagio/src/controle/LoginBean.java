package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.Administrador;
import modelo.Atendente;
import modelo.Operador;
import util.TipoDeUsuario;
import util.Usuario;
import dao.AdministradorDAO;
import dao.AdministradorJPADAO;
import dao.AtendenteDAO;
import dao.AtendenteJPADAO;
import dao.OperadorDAO;
import dao.OperadorJPADAO;

@ManagedBean
public class LoginBean extends AbstractBean {

	private Usuario usuario = new Usuario();
	private TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();

	public LoginBean() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		addPadrao();
	}

	public String logar() {
		try {
			if (this.usuario.getTipo().equals(
					this.tipoDeUsuario.getAdministrador())) {
				AdministradorDAO adminDAO = new AdministradorJPADAO();
				Administrador a = adminDAO.find(this.usuario.getLogin());
				if (a != null && a.getSenha().equals(this.usuario.getSenha())) {
					HttpSession sessao = (HttpSession) FacesContext
							.getCurrentInstance().getExternalContext()
							.getSession(true);
					sessao.setAttribute("login", this.usuario.getLogin());
					sessao.setAttribute("tipo", this.usuario.getTipo());
					return "/pages/admin/home-admin.xhtml?faces-redirect=true";
				} else {
					throw new Exception();
					/*
					 * Mensagem msg = new
					 * Mensagem("Usuário ou senha inválidos!", false, true);
					 * ELFlash.getFlash().put("msg", msg);
					 */
				}
			}

			else if (this.usuario.getTipo().equals(
					this.tipoDeUsuario.getOperador())) {
				OperadorDAO operDAO = new OperadorJPADAO();
				Operador oper = operDAO.find(this.usuario.getLogin());
				if (oper != null
						&& oper.getSenha().equals(this.usuario.getSenha())) {
					HttpSession sessao = (HttpSession) FacesContext
							.getCurrentInstance().getExternalContext()
							.getSession(true);
					sessao.setAttribute("login", this.usuario.getLogin());
					sessao.setAttribute("tipo", this.usuario.getTipo());
					return "/pages/operador/home-operador.xhtml?faces-redirect=true";
				} else {
					throw new Exception();
				}
			} else if (this.usuario.getTipo().equals(
					this.tipoDeUsuario.getAtendente())) {
				AtendenteDAO atenDAO = new AtendenteJPADAO();
				Atendente aten = atenDAO.find(this.usuario.getLogin());
				if (aten != null
						&& aten.getSenha().equals(this.usuario.getSenha())) {
					HttpSession sessao = (HttpSession) FacesContext
							.getCurrentInstance().getExternalContext()
							.getSession(true);
					sessao.setAttribute("login", this.usuario.getLogin());
					sessao.setAttribute("tipo", this.usuario.getTipo());
					return "/pages/atendente/home-atendente.xhtml?faces-redirect=true";
				} else {
					throw new Exception();
				}
			}

		} catch (Exception e) {
			displayErrorMessageToUser("Usu�rio ou senha inv�lido!");
			return "/index.xhtml";
		}

		return "/index.xhtml";

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoDeUsuario getTipoDeUsuario() {
		return tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public void addPadrao() {
		AdministradorDAO aDAO = new AdministradorJPADAO();
		List<Administrador> admins = aDAO.find();
		Administrador a = new Administrador();
		if (admins.isEmpty()) {
			a.setLogin("admin");
			a.setSenha("admin");
			aDAO.save(a);
		}
	}

}
