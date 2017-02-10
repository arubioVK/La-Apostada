package apostada.controladores;

import apostada.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	/*
	@PostMapping("/login")
	public String inicio(@ModelAttribute LoginCredentials credentials) {
		if (usuarioService.checkLogin()) {
			
		}
		
	}*/
	
}
