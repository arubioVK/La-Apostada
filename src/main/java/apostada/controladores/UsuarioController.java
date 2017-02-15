package apostada.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import apostada.entidades.Apuesta;
import apostada.entidades.Equipo;
import apostada.entidades.Liga;
import apostada.entidades.Usuario;
import apostada.servicios.ApuestaService;
import apostada.servicios.EquipoService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;

@Controller
public class UsuarioController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private ApuestaService apuestaService;
	
	@Autowired
	private EquipoService equipoService;
	
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping("/cuenta")
	public String cuenta(Model model) {
		Usuario usuario = sessionService.getUsuarioActual();
		List<Apuesta> apuestasGanadas= apuestaService.findApuestaUserGanada(usuario);
		List<Apuesta> apuestasPerdidas = apuestaService.findApuestaUserPerdida(usuario);
		List<Apuesta> apuestasNoFinalizadas = apuestaService.findApuestaUserNoFinalizada(usuario);

		model.addAttribute("usuario", usuario);
		model.addAttribute("apuestasGanadas", apuestasGanadas);
		model.addAttribute("apuestasPerdidas", apuestasPerdidas);
		model.addAttribute("apuestasNoFinalizadas", apuestasNoFinalizadas);

		//usuario.reclamarApuestas(apuestasGanadas);
/*		for(Apuesta a:apuestasGanadas){
			a.setReclamado(true);
		}
		for(Apuesta a: apuestasPerdidas){
			a.setReclamado(true);
		}*/
		return "cuenta";
	}
	
	/*@RequestMapping("")
	public String reclamar(Model model){
		
		Usuario usuario = sessionService.getUsuarioActual();
		
		List<Apuesta> apuestasGanadas= apuestaService.findApuestaUserGanadasinReclamar(usuario);
		List<Apuesta> apuestasPerdidas = apuestaService.findApuestaUserPerdidasinReclamar(usuario);
		usuario.reclamarApuestas(apuestasGanadas);
		for(Apuesta a:apuestasGanadas){
			a.setReclamado(true);
		}
		for(Apuesta a: apuestasPerdidas){
			a.setReclamado(true);
		}
		return "";
	}*/
	
	
}

