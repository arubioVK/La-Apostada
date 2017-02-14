package apostada.controladores;

import apostada.servicios.SessionService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@Autowired
	private HttpSession httpSession;

	@RequestMapping("/logout")
	public String index(Model model) {
		SessionService utils = new SessionService();
		utils.logoutUsuario();
		
		return "redirect:/";
	}
	
}
