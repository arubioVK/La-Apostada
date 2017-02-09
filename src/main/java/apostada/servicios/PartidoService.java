package apostada.servicios;

import apostada.entidades.Partido;
import apostada.repositorios.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartidoService {
	
	@Autowired
	PartidoRepository partidoRepository;
	
	public Partido findById(long id) {
		return partidoRepository.findOne(id);
	}
	
	public Partido save(Partido partido) {
		return partidoRepository.save(partido);
	}
	
}
