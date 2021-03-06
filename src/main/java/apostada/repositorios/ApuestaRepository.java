package apostada.repositorios;

import apostada.entidades.Apuesta;
import apostada.entidades.Usuario;
import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApuestaRepository extends JpaRepository<Apuesta, Long> {
		
	// Apuestas de un usuario
	List<Apuesta> findByUser(Usuario s);
	
	// Apuestas ganadas de un usuario
	@Query("SELECT a FROM Apuesta a LEFT OUTER JOIN a.partido p WHERE a.user = ?1 AND a.resultado = p.resultado AND p.resultado <> 'null'")
	List<Apuesta> findApuestaByUserGanadas(Usuario s);
	
	// Apuestas perdidas de un usuario
	@Query("SELECT a FROM Apuesta a LEFT OUTER JOIN a.partido p WHERE a.user = ?1 AND a.resultado <> p.resultado AND p.resultado <> 'null'")
	List<Apuesta> findApuestaByUserPerdidas(Usuario s);
	
	// Apuestas ganadas de un usuario no Reclamadas
	@Query("SELECT a FROM Apuesta a LEFT OUTER JOIN a.partido p WHERE a.user = ?1 AND a.resultado = p.resultado AND a.reclamado = 'false'")
	List<Apuesta> findApuestaGanadaNoReclamadaByUser(Usuario s);
	
	// Apuestas perdidas de un usuario no Reclamadas
	@Query("SELECT a FROM Apuesta a LEFT OUTER JOIN a.partido p WHERE a.user = ?1 AND a.resultado <> p.resultado AND a.reclamado = 'false'")
	List<Apuesta> findApuestaPerdidasNoReclamadaByUser(Usuario s);
	
	// Apuestas no finalizadas del usuario
	@Query("SELECT a FROM Apuesta a LEFT OUTER JOIN a.partido p WHERE a.user = ?1 AND p.resultado = 'null'")
	List<Apuesta> findApuestasNoFinalizadasByUser(Usuario s);
	
	List<Apuesta> findByFechaGreaterThanOrderByFechaAsc(Date fecha);
}
