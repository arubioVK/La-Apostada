package apostada.controladores;

import apostada.entidades.Usuario;
import apostada.servicios.UsuarioService;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistroController {
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/registro", method=RequestMethod.GET)
	public String registro(Model model) {
		return "registro";
	}
	
	@RequestMapping(value="/registro", method=RequestMethod.POST)
	public String registro(@ModelAttribute Usuario usuario) {
		Usuario usuarioFound = usuarioService.findByEmail(usuario.getEmail());
		
		if (usuarioFound != null) {
			httpSession.setAttribute("error", "Ese email ya esta en uso");
			return "registro";
		}
		
		if (usuario.getName() == null || usuario.getName().isEmpty()) {
			httpSession.setAttribute("error", "Introduce un nombre");
			return "registro";
		}
		
		if (usuario.getEmail() == null || usuario.getEmail().isEmpty() || !Pattern.compile("^(.+)@(.+)$").matcher(usuario.getEmail()).matches()) {
			httpSession.setAttribute("error", "Email no valido");
			return "registro";
		}
		
		System.out.println(usuario.getPassword());
		
		if (usuario.getPassword() == null || usuario.getPassword().isEmpty() || usuario.getPassword().length() < 4) {
			httpSession.setAttribute("error", "La contraseña es demasiado corta. (min 4)");
			return "registro";
		}
		
		// Save usuario
		usuario.setPuntos(Usuario.PUNTOS_POR_DEFECTO);
		if (usuarioService.save(usuario) != null) {
			httpSession.setAttribute("success", "Ya puedes iniciar sesion");
		} else {
			httpSession.setAttribute("error", "Algo ha ido mal");
		}
		
		return "registro";
	}

}
