package apostada.controladores;

import apostada.entidades.Apuesta;
import apostada.entidades.Partido;
import apostada.entidades.Usuario;
import apostada.servicios.ApuestaService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;
import apostada.servicios.UsuarioService;
import java.util.Date;
import javax.servlet.http.HttpSession;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private ApuestaService apuestaService;
	
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value={"/", "/home",}, method=RequestMethod.GET)
	public String home(Model model) {
		Usuario usuario = sessionService.getUsuarioActual();
		model.addAttribute("usuario", usuario);
		model.addAttribute("num_apuestas", apuestaService.count());
		model.addAttribute("equipos", partidoService.findProximosPartidos());

		return "home";
	}
	
	@RequestMapping(value={"/", "/home",}, method=RequestMethod.POST)
	public String home(Model model, @RequestParam double cuota, @RequestParam Partido partido, @RequestParam int resultado, @RequestParam Date fe, @RequestParam double cantidad ) {
		Usuario usuario = sessionService.getUsuarioActual();

		if (usuario != null) {
			if (usuario.getPuntos() < cantidad) {
				httpSession.setAttribute("error", "No tienes los puntos suficientes");
			} else if (cantidad <= 0) {
				httpSession.setAttribute("error", "Cantidad insuficientes para apostar");
			} else {
				Apuesta apuesta = new Apuesta(partido, usuario ,cuota, cantidad, fe, resultado);
				usuario.restarPuntos(cantidad);
				// Modificar cuotas
				partido.ajusteCuota(cantidad,resultado);
				partidoService.save(partido);
				apuestaService.save(apuesta);

				httpSession.setAttribute("success", "Apuesta realizada");
			}
		} else {
			httpSession.setAttribute("error", "Tienes que iniciar sesion");
		}
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("num_apuestas", apuestaService.count());
		model.addAttribute("equipos", partidoService.findProximosPartidos());

		return "home";
	}
	
}
