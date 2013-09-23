package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.OperadorDAO;
import dao.OperadorJPADAO;

import modelo.Operador;

@ManagedBean
public class OperadorBean extends AbstractBean{
	
	private Operador operador;
	private List<Operador> operadores;
	
	public OperadorBean(){
		this.setOperadores(new ArrayList<Operador>());
		this.setOperador(new Operador());
		pesquisarTodos();
	}
	
	public void cadastrar(){
		OperadorDAO operDAO = new OperadorJPADAO();
		operDAO.save(this.operador);
		displayInfoMessageToUser("Cadastrado com sucesso!");
	}
	
	public void pesquisarTodos(){
		OperadorDAO operDAO = new OperadorJPADAO();
		this.operadores = operDAO.find();
	}
	
	public void excluir(Operador oper){
		OperadorDAO operDAO = new OperadorJPADAO();
		operDAO.delete(oper);
		displayInfoMessageToUser("Excluido com sucesso!");
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
	

}
