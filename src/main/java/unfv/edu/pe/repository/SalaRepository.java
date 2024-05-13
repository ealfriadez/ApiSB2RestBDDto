package unfv.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unfv.edu.pe.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{

}
