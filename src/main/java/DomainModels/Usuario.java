package DomainModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private String name;	
	private String lastname;	
	private String email;	
	private String password;	

	public Usuario() {
		
	}
	
	public Usuario(String nombre, int version) {
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
	
	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
