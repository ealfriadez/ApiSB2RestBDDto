package unfv.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unfv.edu.pe.model.Sala;
import unfv.edu.pe.service.SalaService;

@RestController
@RequestMapping(path = "api/v1/sala")
public class SalaController {

	@Autowired
	SalaService service;
	
	@GetMapping("/full")
	public ResponseEntity<List<Sala>> obtenerSalas(){
		List<Sala> salas = new ArrayList<Sala>();
		service.obtenerTodo().forEach(salas::add);
		if (salas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(salas, HttpStatus.OK);
		}
	}
}
