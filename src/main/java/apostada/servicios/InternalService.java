package apostada.servicios;

import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class InternalService {

	//private static final Logger logger = Logger.getLogger(InternalService.class);
	
	@Autowired
	PartidoService partidoService;
	
	@Autowired
	ApuestaService apuestaService;
	
	@Async
	public synchronized Future<Object> updateCuota() {
		return new AsyncResult<>(new Object());
	}

	/**
	 * Auto reclama las apuesta de los usuarios
	 **/
	@Scheduled(fixedDelay=5000)
	//@Scheduled(fixedRate=5000)
	//@Scheduled(cron = "*/5 * * * * ?")
	public void reclamarApuestas() {
		//logger.debug("Empezar scheduler");
		System.out.println("Empezar a reclamar apuestas");
		
		// Connect to "La Apostada Interno" through SOCKETS
		
		// Partidos no finalizados => finalizar
		/*List<Partido> partidosNoFinalizados = partidoService.findNoJugados();
		for (Partido partido : partidosNoFinalizados) {
			
		}
		
		// Partidos finalizados => reclamar
		List<Partido> partidosFinalizados = partidoService.findAll();
		for (Partido partido : partidosFinalizados) {
			
		}*/
		
		/*Usuario usuario = sessionService.getUsuarioActual();
		
		List<Apuesta> apuestasGanadas = apuestaService.findApuestaUserGanadasinReclamar(usuario);
		List<Apuesta> apuestasPerdidas = apuestaService.findApuestaUserPerdidasinReclamar(usuario);
		usuario.reclamarApuestas(apuestasGanadas);
		for (Apuesta a:apuestasGanadas) {
			a.setReclamado(true);
		}
		for (Apuesta a: apuestasPerdidas) {
			a.setReclamado(true);
		}
		return "";*/

		//logger.debug("Terminar de reclamar apuestas");
		//System.out.println("Terminar scheduler");
	}

}
