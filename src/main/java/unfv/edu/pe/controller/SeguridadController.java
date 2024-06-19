package unfv.edu.pe.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import unfv.edu.pe.exception.ResourceNotFoundException;
import unfv.edu.pe.model.security.Usuario;
import unfv.edu.pe.model.security.UsuarioResponse;
import unfv.edu.pe.service.SeguridadService;

@RestController
@RequestMapping("api/v1/seguridad")
public class SeguridadController {

	@Autowired
	SeguridadService service;
	
	@PostMapping("")
	public ResponseEntity<UsuarioResponse> autenticacionDeUsuario(
			@RequestParam("usuario") String usuario,
			@RequestParam("password") String password){
		
		Usuario objUsuario = service
				.autenticarUsuario(usuario, password)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Usuario o password incorrecto"));
		
		if(objUsuario != null) {
			String token = generarToken(usuario, objUsuario.getIdusuario());
			UsuarioResponse usuarioResponse = 
					new UsuarioResponse(
							objUsuario.getIdusuario(), 
							usuario, 
							token);
			return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
		}
		return null;		
	}
	
	private String generarToken(String usuario, Long idUsuario) {
		final String claveSecreta = "@EALFRIADEZ2024"; //Este dato debe de venir de la BD
		List<GrantedAuthority> lstAutorizacion = AuthorityUtils.createAuthorityList(
				service.listarRolesPorUsuario(idUsuario));
		
		String token = Jwts
				.builder()
				.setId("@elioJWT")
				.setSubject(usuario)
				.claim("authorities", 
						lstAutorizacion.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 300000)) //El tiempo de vida del token  debe de venir de la BD
				.signWith(SignatureAlgorithm.HS512, claveSecreta.getBytes())
				.compact();
				
		return "Bearer " + token;
	}
}
 