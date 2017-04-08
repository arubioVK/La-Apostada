package apostada.repositorios;

import apostada.entidades.Equipo;
import apostada.entidades.Liga;
import apostada.entidades.Partido;

import java.util.Date;
import java.util.List;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@CacheConfig(cacheNames="partidos")
public interface PartidoRepository extends JpaRepository<Partido, Long> {
	
	// Consulta un partido por su id
	@Cacheable
	Partido findPartidaById(Long id);
	
	// Consulta Partidos que se pueden apostar
	@Query("SELECT p FROM Partido p WHERE p.fecha >= ?1 ORDER BY p.fecha ASC")
	List<Partido> findPartidoProximoByFecha(Date f);
	
	// Consulta Partidos de una liga concreta JUGABLES
	@Query("SELECT p FROM Partido p WHERE (p.equipoLocal.liga = ?1) AND (p.fecha >= ?2) ORDER BY p.fecha ASC")
	List<Partido> findPartidoProximoByLigaAndFecha(Liga l, Date f);
	
	// Consulta Partidos Finalizados
	@Cacheable
	@Query("SELECT p FROM Partido p WHERE (p.equipoLocal.liga = ?1) AND (p.resultado BETWEEN 1 AND 3) ORDER BY p.fecha ASC")
	List<Partido> findPartidoFinalizadoByLiga(Liga liga);
	
	// Consulta Partidos de un equipo concreto
	@Query("SELECT p FROM Partido p WHERE (p.equipoLocal = ?1 OR p.equipoVisitante = ?1) AND (p.fecha >= ?2) ORDER BY p.fecha ASC")
	List<Partido> findPartidoProximoByEquipoAndFecha(Equipo equipo, Date f);
	
	// Consulta partidos Finalizados de un equipo
	@Cacheable
	@Query("SELECT p FROM Partido p WHERE (p.equipoLocal = ?1 OR p.equipoVisitante = ?1) AND (p.resultado BETWEEN 1 AND 3) ORDER BY p.fecha ASC")
	List<Partido> findPartidoFinalizadoByEquipo(Equipo equipo);
	
	@Override
	@CacheEvict(allEntries=true)
	Partido save(Partido partido);
	
}
