package apostada.controladores;

import apostada.entidades.Apuesta;
import apostada.entidades.Partido;
import apostada.entidades.Usuario;
import apostada.servicios.ApuestaService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApuestasController {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private PartidoService partidoService;
	
	@Autowired
	private ApuestaService apuestaService;
	
	@RequestMapping(value="/apuesta/apostar", method=RequestMethod.POST)
	public String apostar(Model model, @RequestParam Partido partido, @RequestParam int resultado, @RequestParam double cantidad, @RequestParam String redirect) {
		Usuario usuario = sessionService.getUsuarioActual();
		
		if (usuario != null) {
			if (usuario.getPuntos() < cantidad) {
				httpSession.setAttribute("error", "No tienes los puntos suficientes");
			} else if (cantidad <= 0) {
				httpSession.setAttribute("error", "Cantidad insuficientes para apostar");
			} else {
				Apuesta apuesta = new Apuesta(partido, usuario, partido.getCuotaDeResultado(resultado), cantidad, new Date(), resultado);
				usuario.restarPuntos(cantidad);
				partido.ajusteCuota(cantidad, resultado);
				partidoService.save(partido);
				apuestaService.save(apuesta);

				httpSession.setAttribute("success", "Apuesta realizada");
			}
		} else {
			httpSession.setAttribute("error", "Tienes que iniciar sesion");
		}
		
		return "redirect:" + redirect;
	}
	
}
