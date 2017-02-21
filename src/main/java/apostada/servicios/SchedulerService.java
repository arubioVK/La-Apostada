package apostada.servicios;

import apostada.entidades.Partido;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

	protected static Logger logger = Logger.getLogger("service");	

	@Autowired
	PartidoService partidoService;
	
	@Autowired
	ApuestaService apuestaService;
	
	@Scheduled(fixedDelay=5000)
	//@Scheduled(fixedRate=5000)
	//@Scheduled(cron = "*/5 * * * * ?")
	public void doSchedule() {
		logger.debug("Empezar scheduler");
		
		
		
		// Partidos no finalizados => finalizar
		List<Partido> partidosNoFinalizados = partidoService.findNoJugados();
		for (Partido partido : partidosNoFinalizados) {
			
		}
		
		// Partidos finalizados => reclamar
		List<Partido> partidosFinalizados = partidoService.findAll();
		for (Partido partido : partidosFinalizados) {
			
		}

		logger.debug("Terminar scheduler");
	}

}
