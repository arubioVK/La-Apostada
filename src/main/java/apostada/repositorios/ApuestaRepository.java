package apostada.repositorios;

import apostada.entidades.Apuesta;
import apostada.entidades.Usuario;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApuestaRepository extends JpaRepository<Apuesta, Long> {
	
	//Apuestas ganadas de un usuario
	@Query("SELECT a FROM Apuesta a JOIN a.partido p WHERE a.user=?1 AND a.resultado=p.resultado AND p.resultado<>'null'")
	List<Apuesta> findApuestaByUserGanadas(Usuario s);
	//Apuestas perdidas de un usuario
	@Query("SELECT a FROM Apuesta a JOIN a.partido p WHERE a.user=?1 AND a.resultado<>p.resultado AND p.resultado<>'null'")
	List<Apuesta> findApuestaByUserPerdidas(Usuario s);
	//Apuestas ganadas de un usuario no Reclamadas
	@Query("SELECT a FROM Apuesta a JOIN a.partido p WHERE a.user=?1 AND a.resultado=p.resultado AND a.reclamado = 'false'")
	List<Apuesta> findApuestaByUserGanadasnoReclamadas(Usuario s);
	//Apuestas perdidas de un usuario no Reclamadas
	@Query("SELECT a FROM Apuesta a JOIN a.partido p WHERE a.user=?1 AND a.resultado<>p.resultado AND a.reclamado = 'false'")
	List<Apuesta> findApuestaByUserPerdidasnoReclamadas(Usuario s);
	//Apuestas de un usuario
	@Query("SELECT a FROM Apuesta a WHERE a.user=?1")
	List<Apuesta> findApuestaByUser(Usuario s);
	//apuestas no finalizadas del usuario
	@Query("SELECT a FROM Apuesta a JOIN a.partido p WHERE a.user=?1 AND p.resultado='null'")
	List<Apuesta> findApuestasNoFinalizadas(Usuario s);
	//Todas las apuestas
	@Query("SELECT a FROM Apuesta a")
	List<Apuesta> findApuesta();
	
}
