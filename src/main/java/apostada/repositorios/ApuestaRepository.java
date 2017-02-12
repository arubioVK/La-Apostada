package apostada.repositorios;

import apostada.entidades.Apuesta;
import apostada.entidades.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApuestaRepository extends JpaRepository<Apuesta, Long> {
	
	/*//Apuestas ganadas de un usuario
	@Query("SELECT a FROM Apuesta a JOIN a.partido p WHERE a.user=?1 AND a.resultado=p.resultado")
	List<Apuesta> findApyestaByUser(Usuario s);
	//Apuestas de un usuario
	@Query("SELECT a FROM Apuesta a WHERE a.user=?1")
	List<Apuesta> findApuestaByUser(Usuario s);*/
	//Todas las apuestas
	@Query("SELECT a FROM Apuesta a")
	List<Apuesta> findApuesta();
	
}