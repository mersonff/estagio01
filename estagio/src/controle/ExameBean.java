package controle;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import modelo.Exame;
import modelo.Paciente;
import dao.ExameDAO;
import dao.ExameJPADAO;
import dao.PacienteDAO;
import dao.PacienteJPADAO;

@ManagedBean
public class ExameBean extends AbstractBean {
	private Exame exame;
	private List<Exame> exames;
	private List<Exame> deHoje;
	private List<Exame> examesFiltrados;
	private Date inicio;
	private Date fim;
	private int quantTodos;
	private int quantBaciloscopia;
	private int quantHemograma;
	private int quantBioquimica;
	private int quantParasitologicoFezes;
	private int quantPlaqueta;
	private int quantSanguineo;
	private int quantUrina;
	private String tipo;

	private final static String[] status;
	static {
		status = new String[3];
		status[0] = "Em espera";
		status[1] = "Em aberto";
		status[2] = "Concluído";
	}

	private SelectItem[] statusOptions;

	public ExameBean() {
		this.setExame(new Exame());
		this.setExames(new ArrayList<Exame>());
		pesquisarTodos();
		statusOptions = createFilterOptions(status);

	}

	public void cadastrar() {
		ExameDAO operDAO = new ExameJPADAO();
		PacienteDAO pDAO = new PacienteJPADAO();
		Paciente p = pDAO.find(this.exame.getPaciente().getNumeroSus());
		if (p != null) {
			operDAO.save(this.exame);
			displayInfoMessageToUser("Cadastrado com sucesso!");
		} else {
			displayInfoMessageToUser("Paciente não cadastrado." + "");
		}
	}

	public void pesquisarTodos() {
		ExameDAO operDAO = new ExameJPADAO();
		this.exames = operDAO.find();
	}

	public void excluir(Exame exame) {
		ExameDAO operDAO = new ExameJPADAO();
		operDAO.delete(exame);
		displayInfoMessageToUser("Excluido com sucesso!");
	}
	
	public void quantPacientesAtendidos(){
		ExameDAO exameDAO = new ExameJPADAO();
		List<Exame> exames = exameDAO.quantPacientesAtendidos(this.inicio, this.fim);
		this.quantTodos = exames.size();
	}
	
	public void quantExame(){
		ExameDAO exameDAO = new ExameJPADAO();
		List<Exame> exames = exameDAO.quantGeralExame(this.inicio, this.fim);
		this.quantTodos = exames.size();
		for(Exame ex: exames){
			if(ex.getNomeTipo().equals("Baciloscopia")){
				this.quantBaciloscopia++;
			}else if(ex.getNomeTipo().equals("Hemograma")){
				this.quantHemograma++;
			}else if(ex.getNomeTipo().equals("Bioquimica")){
				this.quantBioquimica++;
			}else if(ex.getNomeTipo().equals("Parasitologico de Fezes")){
				this.quantParasitologicoFezes++;
			}else if(ex.getNomeTipo().equals("Hb / Ht com Plaquetas")){
				this.quantPlaqueta++;
			}else if(ex.getNomeTipo().equals("Classificacao Sanguinea")){
				this.quantSanguineo++;
			}else if(ex.getNomeTipo().equals("Urina")){
				this.quantUrina++;
			}
		}
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public List<Exame> getExamesFiltrados() {
		return examesFiltrados;
	}

	public void setExamesFiltrados(List<Exame> examesFiltrados) {
		this.examesFiltrados = examesFiltrados;
	}

	private SelectItem[] createFilterOptions(String[] data) {
		SelectItem[] options = new SelectItem[data.length + 1];

		options[0] = new SelectItem("", "Selecione");
		for (int i = 0; i < data.length; i++) {
			options[i + 1] = new SelectItem(data[i], data[i]);
		}

		return options;
	}

	public SelectItem[] getStatusOptions() {
		return statusOptions;
	}

	public List<Exame> getDeHoje() throws ParseException {
		List<Exame> temp = new ArrayList<Exame>();
		for (Exame e : exames) {
			if (e.isHoje() == true && e.getStatus().equals("Em espera")) {
				temp.add(e);
			}
		}
		deHoje = temp;
		return deHoje;
	}

	public void setDeHoje(List<Exame> deHoje) {
		this.deHoje = deHoje;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public int getQuanTodos() {
		return quantTodos;
	}

	public void setQuanTodos(int quantTodos) {
		this.quantTodos = quantTodos;
	}

	public int getQuantBaciloscopia() {
		return quantBaciloscopia;
	}

	public void setQuantBaciloscopia(int quantBaciloscopia) {
		this.quantBaciloscopia = quantBaciloscopia;
	}

	public int getQuantHemograma() {
		return quantHemograma;
	}

	public void setQuantHemograma(int quantHemograma) {
		this.quantHemograma = quantHemograma;
	}

	public int getQuantBioquimica() {
		return quantBioquimica;
	}

	public void setQuantBioquimica(int quantBioquimica) {
		this.quantBioquimica = quantBioquimica;
	}

	public int getQuantParasitologicoFezes() {
		return quantParasitologicoFezes;
	}

	public void setQuantParasitologicoFezes(int quantParasitologicoFezes) {
		this.quantParasitologicoFezes = quantParasitologicoFezes;
	}

	public int getQuantPlaqueta() {
		return quantPlaqueta;
	}

	public void setQuantPlaqueta(int quantPlaqueta) {
		this.quantPlaqueta = quantPlaqueta;
	}

	public int getQuantSanguineo() {
		return quantSanguineo;
	}

	public void setQuantSanguineo(int quantSanguineo) {
		this.quantSanguineo = quantSanguineo;
	}

	public int getQuantUrina() {
		return quantUrina;
	}

	public void setQuantUrina(int quantUrina) {
		this.quantUrina = quantUrina;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
