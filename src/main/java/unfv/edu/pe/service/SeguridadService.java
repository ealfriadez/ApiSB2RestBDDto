package unfv.edu.pe.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unfv.edu.pe.model.security.RolUsuario;
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
	
	public String[] listarRolesPorUsuario(Long idusuario) {
		List<RolUsuario> rolesusuario = rolUsuarioRepository.listarRolesPorUsuario(idusuario);
		String[] listarRoles = new String[rolesusuario.size()];
		for (int i = 0; i < rolesusuario.size(); i++) {
			listarRoles[i] = rolesusuario.get(i).getNomrol();			
		}
		return listarRoles;
	}
}
