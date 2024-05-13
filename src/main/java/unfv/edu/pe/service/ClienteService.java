package unfv.edu.pe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import unfv.edu.pe.model.Cliente;
import unfv.edu.pe.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	public Optional<Cliente> buscarClientePorDni(String dniCliente){		
		Optional<Cliente> cliente = repository.buscarClientePorDniNativeQuery(dniCliente);
		if(cliente.isEmpty()) {
			return Optional.empty();
		}else {
			return cliente;
		}
	} 
	
	public Page<Cliente> buscarClientePorNombre(String nombreCliente, Pageable pageable){		
		return repository.buscarClientePorNombreNativeQuery(nombreCliente, pageable);
	}
}
