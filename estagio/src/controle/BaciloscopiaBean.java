package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Baciloscopia;
import dao.BaciloscopiaDAO;
import dao.BaciloscopiaJPADAO;

@ManagedBean
public class BaciloscopiaBean extends AbstractBean {
	private Baciloscopia baciloscopia;
	private List<Baciloscopia> baciloscopias;
	
	

	public BaciloscopiaBean() {
		this.setBaciloscopia(new Baciloscopia());
		this.setBaciloscopias(new ArrayList<Baciloscopia>());
		pesquisarTodos();
	}
	
	public void cadastrar(){
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		operDAO.save(this.baciloscopia);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}
	
	public void pesquisarTodos(){
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		this.baciloscopias = operDAO.find();
	}
	
	public void excluir(Baciloscopia bacil){
		BaciloscopiaDAO operDAO = new BaciloscopiaJPADAO();
		operDAO.delete(bacil);
		displayInfoMessageToUser("Excluido com sucesso!");
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

}
