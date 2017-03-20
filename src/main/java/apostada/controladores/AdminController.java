package apostada.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apostada.entidades.Equipo;
import apostada.entidades.Partido;
import apostada.entidades.Usuario;
import apostada.servicios.EquipoService;
import apostada.servicios.FlashService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private FlashService flashService;

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private EquipoService equipoService;
	
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("usuario", sessionService.getUsuarioActual());
		model.addAttribute("num_apuestas", partidoService.findProximosPartidos().size());
		model.addAttribute("partidos", partidoService.findProximosPartidos());
		return "admin";
	}
	
	
	@RequestMapping(value="/partido", method=RequestMethod.POST)
	public String partidoNuevo(Model model, @RequestParam int ano,@RequestParam int mes,@RequestParam int dia,@RequestParam int hora,@RequestParam int min, @RequestParam String equipoLocal, @RequestParam String equipoVisitante, @RequestParam double cuotaLocal, @RequestParam double cuotaEmpate, @RequestParam double cuotaVisitante) {
		Usuario usuario = sessionService.getUsuarioActual();
		if (usuario != null) {
			Equipo eLocal = equipoService.findByName(equipoLocal);
			Equipo eVisitante = equipoService.findByName(equipoVisitante);
			if(eLocal == null||eVisitante == null){
				flashService.setError("No existe el equipo");
			}
			else if (eLocal.getLiga() != eVisitante.getLiga()){
				flashService.setError("No pertenecen a la misma liga");
			}
			ano = ano-1900;
			partidoService.save(new Partido(eLocal,eVisitante,cuotaLocal,cuotaEmpate,cuotaVisitante,new Date(ano,mes,dia,hora,min,00)));

			flashService.setSuccess("Partido Añadido");

		} else {
			flashService.setError("Tienes que iniciar sesion");
		}
		model.addAttribute("num_apuestas", partidoService.findProximosPartidos().size());
		model.addAttribute("partidos", partidoService.findProximosPartidos());
		return "admin";
	}
	
	
	@RequestMapping(value="/resultado", method=RequestMethod.POST)
	public String resultadoNuevo(Model model, @RequestParam Partido partido, @RequestParam int golLocal, @RequestParam int golVisitante, @RequestParam String redirect) {
		Usuario usuario = sessionService.getUsuarioActual();
		
		if (usuario != null) {
				partido.nuevoResultado(golLocal, golVisitante);
				partidoService.save(partido);
				flashService.setSuccess("Resultado Añadido");

		} else {
			flashService.setError("Tienes que iniciar sesion");
		}
		model.addAttribute("num_apuestas", partidoService.findProximosPartidos().size());
		model.addAttribute("partidos", partidoService.findProximosPartidos());
		
		return "redirect:" + redirect;
	}
	
}
