package unfv.edu.pe.model.dto;

public class EstadoDto implements DtoEntity{

	private String descestado;

	public String getDescestado() {
		return descestado;
	}

	public void setDescestado(String descestado) {
		this.descestado = descestado;
	}

	public EstadoDto() {		
	}

	public EstadoDto(String descestado) {
		super();
		this.descestado = descestado;
	}
}
