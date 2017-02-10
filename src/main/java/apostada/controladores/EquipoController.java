package apostada.controladores;

import apostada.entidades.Equipo;
import apostada.servicios.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EquipoController {

	@Autowired
	EquipoService equipoService;

	@RequestMapping("/equipo/{id}")
	public String inicio(@PathVariable long id, Model model) {
		Equipo equipo = equipoService.findById(id);
		
		if (equipo != null) {
			model.addAttribute("equipo", equipo);
			return "equipo";	
		} else {
			return "404";
		}
	}
	
}
