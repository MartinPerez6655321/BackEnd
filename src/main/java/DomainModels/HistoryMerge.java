package DomainModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HistoryMerge {

	@Id
	@GeneratedValue
	private Long id;
	private Long idPostMusico;
	private Long idPostBanda;
	
	public HistoryMerge() {
		
	}
	
	public HistoryMerge(Long idPostMusico, Long idPostBanda) {
		this.setIdPostMusico(idPostMusico);
		this.setIdPostBanda(idPostBanda);
	}

	// get / set ID
    
	public Long getId() {
		return id;
    }
	
    private void setId(Long id) {
		this.id = id;
    }
    
	// Get / Set IdPostMusico
	
	public Long getIdPostMusico() {
		return idPostMusico;
	}

	public void setIdPostMusico(Long idPostMusico) {
		this.idPostMusico = idPostMusico;
	}
	
	// Get / Set IdPostBanda
	
	public Long getIdPostBanda() {
		return idPostBanda;
	}

	public void setIdPostBanda(Long idPostBanda) {
		this.idPostBanda = idPostBanda;
	}

}
