package apostada.controladores;

import apostada.entidades.Apuesta;
import apostada.entidades.Equipo;
import apostada.entidades.Partido;
import apostada.servicios.ApuestaService;
import apostada.servicios.EquipoService;
import apostada.servicios.PartidoService;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EquipoController {

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private ApuestaService apuestaService;
	
	@Autowired
	EquipoService equipoService;

	@Autowired
	PartidoService partidoService;
	
	@RequestMapping("/equipo/{id}")
	public String inicio(@PathVariable long id, Model model, @RequestParam double cuota, @RequestParam Partido partido, @RequestParam int resultado, @RequestParam Date fe, @RequestParam double cantidad ) {
		Equipo equipo = equipoService.findById(id);
		 
		if (equipo != null) {
			model.addAttribute("equipos", partidoService.findByEquipo(equipo));
			model.addAttribute("equipo", equipo);
			
			if(u.getPuntos()< cantidad){
				httpSession.setAttribute("error","No tienes los puntos suficientes");
			}
			else if(cantidad<=0){
				httpSession.setAttribute("error","Cantidad insuficientes para apostar");
			}
			else{
				Apuesta apuesta = new Apuesta(partido,u ,cuota, cantidad, fe, resultado);
				u.restarPuntos(cantidad);
				//Modificar cuotas
				partido.ajusteCuota(cantidad,resultado);
				partidoService.save(partido);
				apuestaService.save(apuesta);
				
				httpSession.setAttribute("success","Apuesta realizada");
			}
			
			
			
			
			
			return "equipo";	
		} else {
			return "404";
		}
	}
	
}
