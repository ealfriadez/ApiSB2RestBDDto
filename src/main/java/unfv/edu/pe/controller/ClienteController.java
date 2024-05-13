package unfv.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unfv.edu.pe.exception.ResourceNotFoundException;
import unfv.edu.pe.model.Cliente;
import unfv.edu.pe.service.ClienteService;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@GetMapping("/dni/{dni}")
	public ResponseEntity<Cliente> buscarClientePorDni(
			@PathVariable("dni") String dni)
	{
		Cliente cliente = service.buscarClientePorDni(dni)
				.orElseThrow(()-> new ResourceNotFoundException("Cliente con el dni: " + dni + " no se encuentra registrado"));						
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<?> buscarClientesPorNombre(
			@RequestParam String nombre, 
			Pageable pageable
			)
	{
		Page<Cliente> clientes = service.buscarClientePorNombre(nombre, pageable);
		if(clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	
	
}
