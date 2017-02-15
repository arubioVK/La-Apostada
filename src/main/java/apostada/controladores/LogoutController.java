package apostada.controladores;

import apostada.servicios.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@Autowired
	private SessionService sessionService;

	@RequestMapping("/logout")
	public String index(Model model) {
		if (sessionService.getUsuarioActual() == null) {
			return "redirect:/";
		}
		
		sessionService.logoutUsuario();
		
		return "redirect:/";
	}
	
}
