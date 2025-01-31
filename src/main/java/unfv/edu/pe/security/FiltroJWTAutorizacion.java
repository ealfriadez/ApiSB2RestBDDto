package unfv.edu.pe.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltroJWTAutorizacion extends OncePerRequestFilter{

	private final String HEADER  = "Authorization";
	private final String PREFIJO = "Bearer";
	private final String KEY 	 = "@EALFRIADEZ2024";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			if (validarUsoDeJWTToken(request, response)) {
				Claims claims = validarToken(null);
				if (claims.get("authorities") != null) {
					crearAutenticacion(claims);
				}else {
					SecurityContextHolder.clearContext();
				}
			}else {
				SecurityContextHolder.clearContext();
			}
			filterChain.doFilter(request, response);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException ex) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN,
					ex.getMessage());
		}		
	}		

	@SuppressWarnings("unchecked")
	private void crearAutenticacion(Claims claims) {
		List<String> autorizaciones = (List<String>) claims.get("authorities");
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(
						claims.getSubject(), 
						null,
						autorizaciones.stream()
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList())
						);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	}
	
	private Claims validarToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER)
				.replace(PREFIJO, "");
		return Jwts.parser().setSigningKey(KEY.getBytes())
				.parseClaimsJws(jwtToken).getBody();
	}	

	private boolean validarUsoDeJWTToken(
			HttpServletRequest request,
			HttpServletResponse response
			) {		
		String autenticacion = request.getHeader(HEADER); 
		if(autenticacion == null || !autenticacion.startsWith(PREFIJO)) {
			return false;
		}
		return true;
	}
}
