package unfv.edu.pe.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unfv.edu.pe.model.Empleado;
import unfv.edu.pe.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	EmpleadoRepository repository;
	
	public HashMap<String, String> registrarEmpleado(Empleado empleado){
		repository.registrarEmpleado(
				empleado.getNombre(), 
				empleado.getApellido());
		HashMap<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("mensaje", "Elemento registrado correctamente");
		return respuesta;
	}
}
