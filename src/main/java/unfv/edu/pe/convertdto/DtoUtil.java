package unfv.edu.pe.convertdto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import unfv.edu.pe.model.dto.DtoEntity;

@Component
public class DtoUtil {

	public DtoEntity convertirADto(Object obj, DtoEntity mapper) {
		return new ModelMapper().map(obj, mapper.getClass());
	}
	
	public Object convertirAEntity(Object obj, DtoEntity mapper) {
		return new ModelMapper().map(mapper, obj.getClass());
	}
}
