package apostada.repositorios;

import apostada.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	List<Usuario> findByName(String name);
	
}
