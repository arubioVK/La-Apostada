package apostada.controladores;

import apostada.entidades.Apuesta;
import apostada.entidades.Equipo;
import apostada.entidades.Partido;
import apostada.entidades.Usuario;
import apostada.servicios.ApuestaService;
import apostada.servicios.EquipoService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EquipoController {

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private ApuestaService apuestaService;
	
	@Autowired
	private EquipoService equipoService;

	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value="/equipo/{id}", method=RequestMethod.GET)
	public String inicio(@PathVariable long id, Model model) {
		Usuario usuario = sessionService.getUsuarioActual();
		Equipo equipo = equipoService.findById(id);
		
		if (equipo != null) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("equipos", partidoService.findByEquipo(equipo));
			model.addAttribute("equipo", equipo);
			
			return "equipo";	
		}
		
		return "404";
	}
	
	@RequestMapping(value="/equipo/{id}", method=RequestMethod.POST)
	public String inicio(@PathVariable long id, Model model, @RequestParam double cuota, @RequestParam Partido partido, @RequestParam int resultado, @RequestParam double cantidad ) {
		Usuario usuario = sessionService.getUsuarioActual();
		Equipo equipo = equipoService.findById(id);
		
		if (equipo != null) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("equipos", partidoService.findByEquipo(equipo));
			model.addAttribute("equipo", equipo);
			
			if (usuario != null) {
				if (usuario.getPuntos() < cantidad) {
					httpSession.setAttribute("error", "No tienes los puntos suficientes");
				} else if (cantidad <= 0) {
					httpSession.setAttribute("error", "Cantidad insuficientes para apostar");
				} else {
					Apuesta apuesta = new Apuesta(partido, usuario, cuota, cantidad, new Date(), resultado);
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
			
			return "equipo";	
		}
		
		return "404";
	}
	
}
