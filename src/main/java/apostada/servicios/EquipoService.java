package apostada.servicios;

import apostada.entidades.Equipo;
import apostada.repositorios.EquipoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipoService {
	
	@Autowired
	EquipoRepository equipoRepository;
	
	public Equipo findById(long id) {
		return equipoRepository.findOne(id);
	}
	
	public List<Equipo> findByName(String name) {
		return equipoRepository.findByName(name);
	}
	
	public List<Equipo> findAll() {
		return equipoRepository.findAll();
	}
	
	public Long count() {
		return equipoRepository.count();
	}
	
	public boolean exists(long id) {
		return equipoRepository.exists(id);
	}
	
	public Equipo save(Equipo equipo) {
		return equipoRepository.save(equipo);
	}
	
	public void delete(Equipo equipo) {
		equipoRepository.delete(equipo);
	}
	
}
