package DomainModels;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Postulacion_Banda {

	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private int años_de_experiencia;

	@ManyToOne (cascade = CascadeType.ALL)	
	private Instrumento instrumento;

	@ManyToOne (cascade = CascadeType.ALL)	
	private Usuario usuario;
	
	public Postulacion_Banda() {

	}
	
	public Postulacion_Banda(int versio, int años_de_experiencia) {
		this.setVersion(version);
		this.setExperiencia(años_de_experiencia);
	}


	public Long getId() {
		return id;
    }
	
    private void setId(Long id) {
		this.id = id;
    }
	
	// Get / Set Instrumento

	public Instrumento getInstrumento() {
		return instrumento;
	}
	
	public void setInstrumento(Instrumento instr) {
		this.instrumento = instr;
	}

    private void setVersion(int version) {
		this.version = version;
    }
    
    public int getVersion() {
		return version;
	}
	// Get / Set IdMusico

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// Get / Set Genero
	
	public int getExperiencia() {
		return años_de_experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.años_de_experiencia = experiencia;
	}

}
