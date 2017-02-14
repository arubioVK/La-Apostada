package apostada.controladores;

import apostada.entidades.Usuario;
import apostada.servicios.UsuarioService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {

	@Autowired
	HttpSession httpSession;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute Usuario usuario) {
		if (usuario.getEmail() != null && !usuario.getEmail().isEmpty()
				&& usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
			if (usuarioService.checkLogin(usuario)) {
				return "home";
			} else {
				httpSession.setAttribute("error", "Email o contraseña incorrectos");
			}
		}
		
		return "login";
	}
	
}
