package unfv.edu.pe.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unfv.edu.pe.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query(value = "SELECT c FROM CLIENTE c WHERE c.dnicliente = :dnicliente")
	Optional<Cliente> buscarClientePorDniJpql(@Param("dnicliente") String dnicliente);
	
	@Query(value = "SELECT * FROM cliente WHERE cliente.dnicliente = :dnicliente", 
			nativeQuery = true)
	Optional<Cliente> buscarClientePorDniNativeQuery(@Param("dnicliente") String dnicliente);
	
	@Query(
			value = "SELECT * FROM cliente WHERE cliente.nomcliente LIKE %:nomcliente%",
			nativeQuery = true,
			countQuery = "SELECT count(*) FROM cliente"   //Para paginacion
			)
	Page<Cliente> buscarClientePorNombreNativeQuery(@Param("nomcliente") String nomcliente, Pageable pageable);
}
