package unfv.edu.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idempleado;
	
	@Column(name = "nombre")	
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;

	public Long getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Empleado(String nombre, String apellido) {
		super();		
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Empleado() {
		super();
	}		
}
