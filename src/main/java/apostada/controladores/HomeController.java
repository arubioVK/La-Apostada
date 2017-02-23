package apostada.controladores;

import apostada.entidades.Usuario;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class HomeController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("usuario", sessionService.getUsuarioActual());
		model.addAttribute("num_apuestas", partidoService.findProximosPartidos().size());
		model.addAttribute("partidos", partidoService.findProximosPartidos());

		return "home";
	}
	
}
