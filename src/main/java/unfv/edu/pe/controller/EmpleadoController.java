package unfv.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unfv.edu.pe.model.Empleado;
import unfv.edu.pe.service.EmpleadoService;

@RestController
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService service;
	
	@PostMapping
	public ResponseEntity<?> registrarEmpleado(@RequestBody Empleado empleado){
		return new ResponseEntity<>(service.registrarEmpleado(new Empleado(
				empleado.getNombre(), empleado.getApellido())), HttpStatus.CREATED);
	}
}
