package apostada.controladores;

import apostada.entidades.Liga;
import apostada.entidades.Usuario;
import apostada.servicios.LigaService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LigaController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private LigaService ligaService;
	
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value="/liga/{id}", method=RequestMethod.GET)
	public String inicio(@PathVariable long id, Model model) {
		Usuario usuario = sessionService.getUsuarioActual();
		Liga liga =ligaService.findById(id);
		
		if (liga != null) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("liga", liga);
			model.addAttribute("partidos", partidoService.findByLiga(liga));

			return "liga";
		}
		
		return "404";
	}
	
}
