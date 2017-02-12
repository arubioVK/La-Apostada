package apostada.controladores;

import apostada.servicios.ApuestaService;
import apostada.servicios.PartidoService;
import apostada.servicios.UsuarioService;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	@Autowired
	private PartidoService partidoService;
	@RequestMapping(value={"/", "/home",})
	public String home(Model model) {
		model.addAttribute("num_apuestas", apuestaService.count());
		model.addAttribute("equipos", partidoService.findAll());

		return "home";
	}
	
}
