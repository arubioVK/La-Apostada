package apostada.servicios;

import apostada.entidades.Equipo;
import apostada.entidades.Liga;
import apostada.entidades.Partido;
import apostada.repositorios.PartidoRepository;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartidoService {
	
	@Autowired
	PartidoRepository partidoRepository;
	
	public Long count() {
		return partidoRepository.count();
	}
	
	public Partido findById(long id) {
		return partidoRepository.findOne(id);
	}
	
	public List<Partido> findAll() {
		return partidoRepository.findAll();
	}
	
	public List<Partido> findProximosByEquipo(Equipo equipo) {
		// Para equipo
		return partidoRepository.findPartidoProximoByEquipoAndFecha(equipo, new Date());
	}
	
	public List<Partido> findProximosByLiga(Liga liga) {
		// Para liga
		return partidoRepository.findPartidoProximoByLigaAndFecha(liga, new Date());
	}
	
	public List<Partido> findJugadosByEquipo(Equipo equipo) {
		// Para equipo JUGADOS
		return partidoRepository.findPartidoFinalizadoByEquipo(equipo);
	}
	
	public List<Partido> findJugadosByLiga(Liga liga) {
		// Para liga JUGADOS
		return partidoRepository.findPartidoFinalizadoByLiga(liga);
	}
	
	public List<Partido> findProximosPartidos() {
		// Para home
		return partidoRepository.findPartidoProximoByFecha(new Date());
	}
	
	public boolean exists(long id) {
		return partidoRepository.exists(id);
	}
	
	public Partido save(Partido partido) {
		return partidoRepository.save(partido);
	}
	
	public void delete(Partido partido) {
		partidoRepository.delete(partido);
	}
	
}
