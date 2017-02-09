package apostada.controladores;

import apostada.entidades.Liga;
import apostada.servicios.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LigaController {

	@Autowired
	LigaService ligaService;
	
	@RequestMapping("/liga/{id}")
	public String inicio(@PathVariable long id, Model model) {
		
		//Liga liga = ligaService.findById(id);
		
		return "Liga" + String.valueOf(id);
	}
	
}
