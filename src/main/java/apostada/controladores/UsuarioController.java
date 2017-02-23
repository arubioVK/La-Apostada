package apostada.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import apostada.entidades.Apuesta;
import apostada.entidades.Usuario;
import apostada.servicios.ApuestaService;
import apostada.servicios.EquipoService;
import apostada.servicios.FlashService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;
import apostada.servicios.UsuarioService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private FlashService flashService;
	
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
		
		return "cuenta";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model) {
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Model model, @RequestParam int puntos) {
		Usuario usuario = sessionService.getUsuarioActual();
		if (usuario == null) {
			return "redirect:/";
		}
		
		if (puntos <= 0) {
			flashService.setError("Puntos tienen que ser mayor a 0");
			return "redirect:/usuario/cuenta";
		}
		
		// Sumar puntos
		usuario.sumarPuntos(puntos);
		if (usuarioService.save(usuario) != null) {
			flashService.setSuccess("Puntos añadidos");
		} else {
			flashService.setError("Algo ha ido mal");
		}
		
		return "redirect:/usuario/cuenta";
	}
	
}

