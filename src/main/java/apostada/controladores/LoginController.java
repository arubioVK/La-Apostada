package apostada.controladores;

import apostada.servicios.SessionService;
import apostada.entidades.Usuario;
import apostada.servicios.UsuarioService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	HttpSession httpSession;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	SessionService sessionService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		if (sessionService.getUsuarioActual() != null) {
			return "redirect:/";
		}
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute Usuario usuario) {
		if (sessionService.getUsuarioActual() != null) {
			return "redirect:/";
		}
		
		if (usuario.getEmail() != null && !usuario.getEmail().isEmpty()
				&& usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
			if (usuarioService.checkLogin(usuario)) {
				
				sessionService.setUsuarioActual(usuarioService.findByEmail(usuario.getEmail()));
				
				return "redirect:/";
			} else {
				httpSession.setAttribute("error", "Email o contraseña incorrectos");
			}
		}
		
		return "login";
	}
	
}
