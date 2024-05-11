package unfv.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unfv.edu.pe.model.Estado;
import unfv.edu.pe.service.EstadoService;

@RestController
@RequestMapping(path = "api/v1/estado")
public class EstadoController {

	@Autowired
	private EstadoService service;
	
	@GetMapping("")
	public ResponseEntity<List<Estado>> ontenerTodo(){
		List<Estado> estados = new ArrayList<Estado>();
		service.obtenerTodo().forEach(estados::add);
		if (estados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(estados, HttpStatus.OK);
		}
	}
}
