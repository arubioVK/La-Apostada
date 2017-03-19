package apostada.servicios;

import apostada.entidades.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SessionService {
	
	@Autowired
	UsuarioService usuarioService;
	
	public Usuario getUsuarioActual() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			return usuarioService.findByEmail(authentication.getName());
		}
		
		return null;
	}
	
	public boolean usuarioActualHasRole(String role) {
		Usuario usuario = this.getUsuarioActual();
		
		return (usuario != null) && usuario.getRoles().contains(role);
	}
	
}
