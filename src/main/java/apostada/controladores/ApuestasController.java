package apostada.controladores;

import apostada.entidades.Apuesta;
import apostada.entidades.Partido;
import apostada.entidades.Usuario;
import apostada.servicios.ApuestaService;
import apostada.servicios.FlashService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/apuesta")
public class ApuestasController {

	@Autowired
	private FlashService flashService;

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private PartidoService partidoService;
	
	@Autowired
	private ApuestaService apuestaService;
	
	@RequestMapping(value="/apostar", method=RequestMethod.POST)
	public String apostar(Model model, @RequestParam Partido partido, @RequestParam int resultado, @RequestParam double cantidad, @RequestParam String redirect) {
		Usuario usuario = sessionService.getUsuarioActual();
		
		if (usuario != null) {
			if (usuario.getPuntos() < cantidad) {
				flashService.setError("No tienes los puntos suficientes");
			} else if (cantidad <= 0) {
				flashService.setError("Cantidad insuficientes para apostar");
			} else {
				Apuesta apuesta = new Apuesta(partido, usuario, partido.getCuotaDeResultado(resultado), cantidad, new Date(), resultado);
				usuario.restarPuntos(cantidad);
				partido.ajusteCuota(cantidad, resultado);
				partidoService.save(partido);
				apuestaService.save(apuesta);

				flashService.setSuccess("Apuesta realizada");
			}
		} else {
			flashService.setError("Tienes que iniciar sesion");
		}
		
		return "redirect:" + redirect;
	}
	
}
