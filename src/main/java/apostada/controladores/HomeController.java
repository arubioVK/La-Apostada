package apostada.controladores;

import apostada.servicios.ApuestaService;
import apostada.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ApuestaService apuestaService;

	@RequestMapping(value={"/", "/home",})
	public String home(Model model) {
		model.addAttribute("num_apuestas", apuestaService.count());
		
		return "home";
	}
	
}
