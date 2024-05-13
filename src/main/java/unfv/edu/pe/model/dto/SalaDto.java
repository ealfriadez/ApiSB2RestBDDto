package unfv.edu.pe.model.dto;

public class SalaDto implements DtoEntity{

	private String descsala;
	private Integer asientos;
	private EstadoDto estado;
	
	public EstadoDto getEstado() {
		return estado;
	}
	public void setEstado(EstadoDto estado) {
		this.estado = estado;
	}
	public String getDescsala() {
		return descsala;
	}
	public void setDescsala(String descsala) {
		this.descsala = descsala;
	}
	public Integer getAsientos() {
		return asientos;
	}
	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}
	public SalaDto() {
	}
	public SalaDto(String descsala, Integer asientos) {
		super();
		this.descsala = descsala;
		this.asientos = asientos;
	}	
}
