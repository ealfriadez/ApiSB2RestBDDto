package unfv.edu.pe.model.security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RolUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idurol;
	private String nomrol;
	
	public Long getIdurol() {
		return idurol;
	}
	public void setIdurol(Long idurol) {
		this.idurol = idurol;
	}
	public String getNomrol() {
		return nomrol;
	}
	public void setNomrol(String nomrol) {
		this.nomrol = nomrol;
	}
	public RolUsuario() {
		super();
	}
}
