package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Paciente;
import modelo.Urina;
import dao.PacienteDAO;
import dao.PacienteJPADAO;
import dao.UrinaDAO;
import dao.UrinaJPADAO;

@ManagedBean
public class UrinaBean extends AbstractBean {
	private Urina urina;
	private List<Urina> urinas;

	public UrinaBean() {
		this.setUrina(new Urina());
		this.setUrinas(new ArrayList<Urina>());
		pesquisarTodos();
	}

	public void cadastrar() {
		UrinaDAO operDAO = new UrinaJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.urina.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.urina);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		UrinaDAO operDAO = new UrinaJPADAO();
		this.urinas = operDAO.find();
	}

	public void excluir(Urina urina) {
		UrinaDAO operDAO = new UrinaJPADAO();
		operDAO.delete(urina);
		displayInfoMessageToUser("Excluido com sucesso!");
	}

	public Urina getUrina() {
		return urina;
	}

	public void setUrina(Urina urina) {
		this.urina = urina;
	}

	public List<Urina> getUrinas() {
		return urinas;
	}

	public void setUrinas(List<Urina> urinas) {
		this.urinas = urinas;
	}

}
