package apostada.servicios;

import apostada.entidades.Equipo;
import apostada.entidades.Liga;
import apostada.entidades.Partido;
import apostada.repositorios.PartidoRepository;
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
	public List<Partido> findByLiga(Liga id) {
		return partidoRepository.findPartidoByLiga(id);
	}
	public List<Partido> findAll() {
		return partidoRepository.findAll();
	}
	public List<Partido> findByEquipo(Equipo id){
		return partidoRepository.findPartidoByEquipoName(id);
	}
	public Long count() {
		return partidoRepository.count();
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
