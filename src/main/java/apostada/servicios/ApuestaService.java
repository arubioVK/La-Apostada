package apostada.servicios;

import apostada.entidades.Apuesta;
import apostada.repositorios.ApuestaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApuestaService {
	
	@Autowired
	ApuestaRepository apuestaRepository;
	
	public Apuesta findById(long id) {
		return apuestaRepository.findOne(id);
	}
	
	public List<Apuesta> findAll() {
		return apuestaRepository.findAll();
	}
	
	public Long count() {
		return apuestaRepository.count();
	}
	
	public boolean exists(long id) {
		return apuestaRepository.exists(id);
	}
	
	public Apuesta save(Apuesta apuesta) {
		return apuestaRepository.save(apuesta);
	}
	
	public void delete(Apuesta apuesta) {
		apuestaRepository.delete(apuesta);
	}
	
}
