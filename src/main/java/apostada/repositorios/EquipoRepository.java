package apostada.repositorios;

import apostada.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
	
	Equipo findByName(String name);
	
}
