package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Plaqueta;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.PlaquetaDAO;
import dao.PlaquetaJPADAO;

@ManagedBean
public class PlaquetaBean extends AbstractBean {
	private Plaqueta plaqueta;
	private List<Plaqueta> plaquetas;

	public PlaquetaBean() {
		this.setPlaqueta(new Plaqueta());
		this.setPlaquetas(new ArrayList<Plaqueta>());
		pesquisarTodos();
	}

	public void cadastrar() {
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.plaqueta.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.plaqueta);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		this.plaquetas = operDAO.find();
	}

	public void excluir(Plaqueta plaq) {
		PlaquetaDAO operDAO = new PlaquetaJPADAO();
		operDAO.delete(plaq);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public Plaqueta getPlaqueta() {
		return plaqueta;
	}

	public List<Plaqueta> getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(List<Plaqueta> plaquetas) {
		this.plaquetas = plaquetas;
	}

	public void setPlaqueta(Plaqueta plaqueta) {
		this.plaqueta = plaqueta;
	}
    
	
}
