package apostada.servicios;

import apostada.entidades.Apuesta;
import apostada.repositorios.ApuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApuestaService {
	
	@Autowired
	ApuestaRepository apuestaRepository;
	
	public Apuesta findById(long id) {
		return apuestaRepository.findOne(id);
	}
	
	public Apuesta save(Apuesta apuesta) {
		return apuestaRepository.save(apuesta);
	}
	
}
