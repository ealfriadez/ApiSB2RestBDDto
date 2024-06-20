package unfv.edu.pe.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Asiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idasiento;	
	
	@Column(name = "nroasiento")
	private Integer nroasiento;

	public Long getIdasiento() {
		return idasiento;
	}

	public void setIdasiento(Long idasiento) {
		this.idasiento = idasiento;
	}

	public Integer getNroasiento() {
		return nroasiento;
	}

	public void setNroasiento(Integer nroasiento) {
		this.nroasiento = nroasiento;
	}	
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idsala")
	private Sala sala;

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}	
}
