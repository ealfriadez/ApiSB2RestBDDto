package unfv.edu.pe.model.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RolUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrol;
	private String nomrol;
	
	public Long getIdurol() {
		return idrol;
	}
	public void setIdurol(Long idurol) {
		this.idrol = idurol;
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
