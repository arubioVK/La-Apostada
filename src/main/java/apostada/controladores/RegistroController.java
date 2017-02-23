package apostada.controladores;

import apostada.entidades.Usuario;
import apostada.servicios.FlashService;
import apostada.servicios.SessionService;
import apostada.servicios.UsuarioService;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	FlashService flashService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String registro(Model model) {
		if (sessionService.getUsuarioActual() != null) {
			return "redirect:/";
		}
		
		return "registro";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String registro(@ModelAttribute Usuario usuario) {
		if (sessionService.getUsuarioActual() != null) {
			return "redirect:/";
		}
		
		if (usuario.getName() == null || usuario.getName().isEmpty()) {
			flashService.setError("Introduce un nombre");
			return "registro";
		}
		
		if (usuario.getEmail() == null || usuario.getEmail().isEmpty() || !Pattern.compile("^(.+)@(.+)$").matcher(usuario.getEmail()).matches()) {
			flashService.setError("Email no valido");
			return "registro";
		}
		
		if (usuario.getPassword() == null || usuario.getPassword().isEmpty() || usuario.getPassword().length() < 4) {
			flashService.setError("La contraseña es demasiado corta. (min 4)");
			return "registro";
		}
		
		Usuario usuarioFound = usuarioService.findByEmail(usuario.getEmail());
		
		if (usuarioFound != null) {
			flashService.setError("Ese email ya esta en uso");
			return "registro";
		}
		
		// Generar hash
		usuario.setPasswordHash(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		
		// Save usuario
		usuario.setPuntos(Usuario.PUNTOS_POR_DEFECTO);
		if (usuarioService.save(usuario) != null) {
			flashService.setSuccess("Ya puedes iniciar sesion");
		} else {
			flashService.setError("Algo ha ido mal");
		}
		
		return "registro";
	}

}
