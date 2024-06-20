package unfv.edu.pe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcliente;
	
	@Column(name = "nomcliente")
	private String nomcliente;
	
	@Column(name = "apecliente")
	private String apecliente;
	
	@Column(name = "dnicliente")
	private String dnicliente;

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getNomcliente() {
		return nomcliente;
	}

	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}

	public String getApecliente() {
		return apecliente;
	}

	public void setApecliente(String apecliente) {
		this.apecliente = apecliente;
	}

	public String getDnicliente() {
		return dnicliente;
	}

	public void setDnicliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}
}
