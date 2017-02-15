package apostada.servicios;

import apostada.entidades.Apuesta;
import apostada.entidades.Usuario;
import apostada.repositorios.ApuestaRepository;

import java.util.Date;
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
	public List<Apuesta> findApuestaUserNoFinalizada(Usuario u){
		return apuestaRepository.findApuestasNoFinalizadas(u);
	}
	public List<Apuesta> findApuestaUserGanada(Usuario u){
		return apuestaRepository.findApuestaByUserGanadas(u);
	}
	public List<Apuesta> findApuestaUserPerdida(Usuario u){
		return apuestaRepository.findApuestaByUserPerdidas(u);
	}	
	public List<Apuesta> findApuestaUser(Usuario u){
		return apuestaRepository.findApuestaByUser(u);
	}
	public List<Apuesta> findApuestaUserGanadasinReclamar(Usuario u){
		return apuestaRepository.findApuestaByUserGanadasnoReclamadas(u);
	}
	public List<Apuesta> findApuestaUserPerdidasinReclamar(Usuario u){
		return apuestaRepository.findApuestaByUserPerdidasnoReclamadas(u);
	}
	
	
	
	
}
