package apostada.controladores;

import apostada.servicios.SessionService;
import apostada.servicios.UsuarioService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	HttpSession httpSession;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	SessionService sessionService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String login(Model model) {
		if (sessionService.getUsuarioActual() != null) {
			return "redirect:/";
		}
		
		return "login";
	}
	
}
