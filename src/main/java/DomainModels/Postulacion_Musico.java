package DomainModels;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Postulacion_Musico {

	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private int genero_musical_id;

	@ManyToOne (cascade = CascadeType.ALL)	
	private Instrumento instrumento;

	@ManyToOne (cascade = CascadeType.ALL)	
	private Usuario usuario;
	
	public Postulacion_Musico() {

	}
	
	public Postulacion_Musico(int version, int genero_musical_id) {
		this.setVersion(version);
		this.setGenero(genero_musical_id);
	}

	// get / set Persona
	
	public Instrumento getInstrumento() {
		return instrumento;
	}
	
	public void setInstrumento(Instrumento instr) {
		this.instrumento = instr;
	}

	public Long getId() {
		return id;
    }
	
    private void setId(Long id) {
		this.id = id;
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
	
	public int getGenero() {
		return genero_musical_id;
	}

	public void setGenero(int genero) {
		this.genero_musical_id = genero;
	}

}
