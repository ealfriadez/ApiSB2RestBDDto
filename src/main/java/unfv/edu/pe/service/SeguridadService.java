package unfv.edu.pe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unfv.edu.pe.model.security.Usuario;
import unfv.edu.pe.repository.RolUsuarioRepository;
import unfv.edu.pe.repository.UsuarioRepository;

@Service
public class SeguridadService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RolUsuarioRepository rolUsuarioRepository;
	
	public Optional<Usuario> autenticarUsuario(String usuario, String password){
		Optional<Usuario> entityOptional = usuarioRepository.autenticarUsuario(usuario, password);
		if(entityOptional.isEmpty()) {
			return Optional.empty();
		}
		return entityOptional;
	}
}
