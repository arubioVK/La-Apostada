package apostada.controladores;

import apostada.entidades.Equipo;
import apostada.entidades.Liga;
import apostada.servicios.LigaService;
import apostada.servicios.PartidoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LigaController {

	@Autowired
	LigaService ligaService;
	@Autowired
	private PartidoService partidoService;
	@RequestMapping("/liga/{id}")
	public String inicio(@PathVariable long id, Model model) {
		Liga liga =ligaService.findById(id);
		model.addAttribute("liga",liga.getName());

		model.addAttribute("equipos",partidoService.findByLiga(liga));
		return "liga" /*+ String.valueOf(id)*/;
	}
	
}
