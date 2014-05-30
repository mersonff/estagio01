package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//Criado por David Costa
@Entity
@SequenceGenerator(name = "sequencia_tipos", sequenceName = "sequencia_tipos") 
public class Tipos{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="sequencia_tipos")
	private long idTipo;
	private String tipoAtendimento;
	private String tipoConsulta;
	private String tipoAreaAtendimento;
	private String tipoLeito;
	
	
	
	
	
	
	public long getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
	}
	public String getTipoAtendimento() {
		return tipoAtendimento;
	}
	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public String getTipoAreaAtendimento() {
		return tipoAreaAtendimento;
	}
	public void setTipoAreaAtendimento(String tipoAreaAtendimento) {
		this.tipoAreaAtendimento = tipoAreaAtendimento;
	}
	public String getTipoLeito() {
		return tipoLeito;
	}
	public void setTipoLeito(String tipoLeito) {
		this.tipoLeito = tipoLeito;
	}
	
	
	
}
