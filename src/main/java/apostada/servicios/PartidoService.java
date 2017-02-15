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
	
	public Partido findById(long id) {
		return partidoRepository.findOne(id);
	}
	
	public List<Partido> findByLiga(Liga id) {//PARA LIGA
		return partidoRepository.findPartidoByLiga(id,new Date());
	}
	
	public List<Partido> findAll() {
		return partidoRepository.findAll();
	}
	
	public List<Partido> findByEquipo(Equipo id){
		return partidoRepository.findPartidoByEquipoName(id, new Date());
	}
	
	public Long count() {
		return partidoRepository.count();
	}
	
	public List<Partido> findJugadosEquipo(Equipo id) {//PARA Partidos de un equipo JUGADOS
		return partidoRepository.findByPartidoEquipoFinalizado(id);
	}
	
	public List<Partido> findJugados(Liga id) {//PARA LIGA JUGADOS
		return partidoRepository.findByPartidoFinalizado(id);
	}
	
	public List<Partido> findNoJugados() {
		Date fecha = new Date();
		return partidoRepository.findPartidoByAnteriorFecha(fecha);
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
	public List<Partido> findProximosPartidos() {//PARA HOME
		return partidoRepository.findPartidoByAnteriorFecha(new Date());
	}
	
}
