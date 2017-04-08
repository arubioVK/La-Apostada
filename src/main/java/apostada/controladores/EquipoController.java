package apostada.controladores;

import apostada.entidades.Equipo;
import apostada.entidades.Usuario;
import apostada.servicios.EquipoService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/equipo")
public class EquipoController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private EquipoService equipoService;

	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String inicio(@PathVariable long id, Model model) {
		Usuario usuario = sessionService.getUsuarioActual();
		Equipo equipo = equipoService.findById(id);
		
		if (equipo != null) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("partidos", partidoService.findProximosByEquipo(equipo));
			model.addAttribute("equipo", equipo);
			
			return "equipo";	
		}
		
		return "404";
	}
	
	@RequestMapping("/{id}/jugados")
	public String partidosJugados(@PathVariable long id, Model model) {
		Equipo equipo = equipoService.findById(id);
		model.addAttribute("equipo", equipo);
		model.addAttribute("partidos", partidoService.findJugadosByEquipo(equipo));
		
		return "equipoJugados";
	}
	
}
