package apostada.servicios;

import apostada.entidades.Liga;
import apostada.repositorios.LigaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LigaService {

	@Autowired
	LigaRepository ligaRepository;
	
	public Liga findById(long id) {
		return ligaRepository.findOne(id);
	}
	
	public List<Liga> findByName(String name) {
		return ligaRepository.findByName(name);
	}
	
	public Liga save(Liga liga) {
		return ligaRepository.save(liga);
	}
	
}
