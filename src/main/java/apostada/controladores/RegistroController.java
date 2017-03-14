package apostada.controladores;

import apostada.entidades.Usuario;
import apostada.servicios.FlashService;
import apostada.servicios.SessionService;
import apostada.servicios.UsuarioService;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String registro(@ModelAttribute Usuario usuario, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
		if (sessionService.getUsuarioActual() != null) {
			return "redirect:/";
		}
		
		if (name == null || name.isEmpty()) {
			flashService.setError("Introduce un nombre");
			return "registro";
		}
		
		if (email == null || email.isEmpty() || !Pattern.compile("^(.+)@(.+)$").matcher(email).matches()) {
			flashService.setError("Email no valido");
			return "registro";
		}
		
		if (password == null || password.isEmpty() || password.length() < 4) {
			flashService.setError("La contraseña es demasiado corta. (min 4)");
			return "registro";}
		
		Usuario usuarioFound = usuarioService.findByEmail(email);
		
		if (usuarioFound != null) {
			flashService.setError("Ese email ya esta en uso");
			return "registro";
		}
		
		Usuario user = new Usuario(name,email,password); 		
				
				
		// Save usuario
		if (usuarioService.save(user) != null) {
			flashService.setSuccess("Ya puedes iniciar sesion");
		} else {
			flashService.setError("Algo ha ido mal");
		}
		
		return "registro";
	}

}
