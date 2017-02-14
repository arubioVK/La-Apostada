package apostada.servicios;

import apostada.entidades.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionService {
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	UsuarioService usuarioService;
	
	public Usuario getUsuarioActual() {
		Long usuarioId = (Long) httpSession.getAttribute("usuario_id");
		
		if (usuarioId != null) {
			return usuarioService.findById(usuarioId);
		}
		
		return null;
	}

	public void setUsuarioActual(Usuario usuario) {
		httpSession.setAttribute("usuario_id", usuario.getId());
	}

	public void logoutUsuario() {
		httpSession.removeAttribute("usuario_id");
	}
	
}
