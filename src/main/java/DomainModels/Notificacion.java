package DomainModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notificacion {

	@Id
	@GeneratedValue
	private Long id;
	private String descripcion;
	private String receptor;
	
	public Notificacion() {
		
	}
	
	public Notificacion(String receptor, String descripcion) {
		this.setReceptor(receptor);
		this.setDescripcion(descripcion);
	}

	// get / set ID
    
	public Long getId() {
		return id;
    }
	
    private void setId(Long id) {
		this.id = id;
    }
    
	// Get / Set IdPostMusico
	
	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	
	// Get / Set IdPostBanda
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
