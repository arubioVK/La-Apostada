package apostada.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

	@RequestMapping("/inicio")
	public String inicio(Model model) {

		
		model.addAttribute("name", " users");
		
		return "index";
	}
	
}
