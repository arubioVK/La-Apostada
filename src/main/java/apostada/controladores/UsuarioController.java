package apostada.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import apostada.entidades.Apuesta;
import apostada.entidades.Partido;
import apostada.entidades.Usuario;
import apostada.servicios.ApuestaService;
import apostada.servicios.EquipoService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;
import apostada.servicios.UsuarioService;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private ApuestaService apuestaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EquipoService equipoService;
	
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping("/cuenta")
	public String cuenta(Model model) {
		Usuario usuario = sessionService.getUsuarioActual();
		if (usuario == null) {
			return "redirect:/";
		}
		
		List<Apuesta> apuestasGanadas= apuestaService.findApuestaUserGanada(usuario);
		List<Apuesta> apuestasPerdidas = apuestaService.findApuestaUserPerdida(usuario);
		List<Apuesta> apuestasNoFinalizadas = apuestaService.findApuestaUserNoFinalizada(usuario);

		model.addAttribute("usuario", usuario);
		model.addAttribute("apuestasGanadas", apuestasGanadas);
		model.addAttribute("apuestasPerdidas", apuestasPerdidas);
		model.addAttribute("apuestasNoFinalizadas", apuestasNoFinalizadas);

		//usuario.reclamarApuestas(apuestasGanadas);
/*		for(Apuesta a:apuestasGanadas){
			a.setReclamado(true);
		}
		for(Apuesta a: apuestasPerdidas){
			a.setReclamado(true);
		}*/
		return "cuenta";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Model model, @RequestParam int puntos) {
		Usuario usuario = sessionService.getUsuarioActual();
		if (usuario == null) {
			return "redirect:/";
		}
		
		if (puntos <= 0) {
			httpSession.setAttribute("error", "Puntos tienen que ser mayor a 0");
			return "redirect:/cuenta";
		}
		
		// Sumar puntos
		usuario.sumarPuntos(puntos);
		if (usuarioService.save(usuario) != null) {
			httpSession.setAttribute("success", "Puntos añadidos");
		} else {
			httpSession.setAttribute("error", "Algo ha ido mal");
		}
		
		return "redirect:/cuenta";
	}
	
	/*@RequestMapping("")
	public String reclamar(Model model){
		
		Usuario usuario = sessionService.getUsuarioActual();
		
		List<Apuesta> apuestasGanadas= apuestaService.findApuestaUserGanadasinReclamar(usuario);
		List<Apuesta> apuestasPerdidas = apuestaService.findApuestaUserPerdidasinReclamar(usuario);
		usuario.reclamarApuestas(apuestasGanadas);
		for(Apuesta a:apuestasGanadas){
			a.setReclamado(true);
		}
		for(Apuesta a: apuestasPerdidas){
			a.setReclamado(true);
		}
		return "";
	}*/
	
	
}

