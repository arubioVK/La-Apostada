package apostada.controladores;

import apostada.entidades.Apuesta;
import apostada.entidades.Partido;
import apostada.servicios.ApuestaService;
import apostada.servicios.PartidoService;
import apostada.servicios.UsuarioService;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private HttpSession httpSession;
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ApuestaService apuestaService;
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value={"/", "/home",})
	public String home(Model model, @RequestParam double cuota, @RequestParam Partido partido, @RequestParam int resultado, @RequestParam Date fe, @RequestParam double cantidad ) {
		
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
			
			httpSession.setAtrribute("success","Apuesta realizada");
		}
		
		model.addAttribute("num_apuestas", apuestaService.count());
		model.addAttribute("equipos", partidoService.findProximosPartidos());

		return "home";
	}
	
}
