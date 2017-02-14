package apostada.controladores;

import apostada.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ApuestasController {

	@Autowired
	private UsuarioService userService;

	@RequestMapping("/apuestas")
	public String index(Model model) {
		
		return "apuestas";
	}
	
}
