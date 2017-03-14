package apostada.servicios;

import apostada.entidades.Usuario;
import apostada.repositorios.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario findById(long id) {
		return usuarioRepository.findOne(id);
	}
	
	public List<Usuario> findByName(String name) {
		return usuarioRepository.findByName(name);
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Long count() {
		return usuarioRepository.count();
	}
	
	public boolean exists(long id) {
		return usuarioRepository.exists(id);
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	
}
