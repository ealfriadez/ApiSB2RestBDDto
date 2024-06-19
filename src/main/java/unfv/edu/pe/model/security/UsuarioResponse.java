package unfv.edu.pe.model.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	private String nomusuario;
	private String token;
	
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getNomusuario() {
		return nomusuario;
	}
	public void setNomusuario(String nomusuario) {
		this.nomusuario = nomusuario;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UsuarioResponse(Long idusuario, String nomusuario, String token) {
		super();
		this.idusuario = idusuario;
		this.nomusuario = nomusuario;
		this.token = token;
	}	
}
