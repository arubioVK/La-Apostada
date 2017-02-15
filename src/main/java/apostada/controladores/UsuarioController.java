package apostada.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import apostada.entidades.Equipo;
import apostada.entidades.Liga;
import apostada.servicios.EquipoService;
import apostada.servicios.PartidoService;

@Controller
public class UsuarioController {

	@Autowired
	private EquipoService equipoService;
	
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping("/cuenta")
	public String cuenta(Model model) {
		
		
		return "cuenta";
	}
	
}
