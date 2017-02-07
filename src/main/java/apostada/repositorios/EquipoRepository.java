package apostada.repositorios;

import apostada.entidades.Equipo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
	
	List<Equipo> findByName(String name);
	
}
