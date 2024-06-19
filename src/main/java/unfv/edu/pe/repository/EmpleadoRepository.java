package unfv.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import unfv.edu.pe.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

	@Transactional
	@Modifying
	@Query(value = "{call sp_RegistrarEmpleado(:nombre, :apellido)}", nativeQuery = true)
	void registrarEmpleado(
			@Param("nombre") String nombre,
			@Param("apellido") String apellido
	);
}
