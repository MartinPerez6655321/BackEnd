package DomainModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Instrumento {

	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private String name;	

	public Instrumento() {
		
	}
	
	public Instrumento(String nombre, int version) {
		this.setName(nombre);
		this.setVersion(version);
	}

	// get / set Name
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
   private void setVersion(int version) {
		this.version = version;
    }
    
    public int getVersion() {
		return version;
	}
	
	// get / set ID
	
    public Long getId() {
		return id;
    }

    private void setId(Long id) {
		this.id = id;
    }

	
}
