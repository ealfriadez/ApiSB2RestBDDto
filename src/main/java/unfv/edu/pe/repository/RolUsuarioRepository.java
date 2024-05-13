package unfv.edu.pe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unfv.edu.pe.model.security.RolUsuario;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long>{

	@Query(value = "{call sp_RolxUsuario(:idusuario)}", nativeQuery = true)
	public List<RolUsuario> listarRolesPorUsuario(
			@Param("idusuario") Long idusuario);			
}
