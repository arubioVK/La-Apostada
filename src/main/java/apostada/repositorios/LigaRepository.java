package apostada.repositorios;

import apostada.entidades.Liga;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigaRepository extends JpaRepository<Liga, Long> {
	
	List<Liga> findByName(String name);
	
}
