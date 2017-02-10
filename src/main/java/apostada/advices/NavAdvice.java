package apostada.advices;

import apostada.entidades.Usuario;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class NavAdvice {

	private final Mustache.Compiler compiler;

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	public NavAdvice(Mustache.Compiler compiler) {
		this.compiler = compiler;
	}

	@ModelAttribute("nav")
	public Mustache.Lambda nav(Map<String, Object> model) {
		return new Nav(compiler, httpSession);
	}

}

class Nav implements Mustache.Lambda {
	
	String body;

	private Mustache.Compiler compiler;
	private HttpSession httpSession;

	public Nav(Mustache.Compiler compiler, HttpSession httpSession) {
		this.compiler = compiler;
		this.httpSession = httpSession;
	}

	@Override
	public void execute(Template.Fragment frag, Writer out) throws IOException {
		
		Map<String, Object> map = (Map<String, Object>) frag.context();
		if (httpSession.getAttribute("id") != null) {
			// Get user
			
		} else {
			Usuario newUsuario = new Usuario();
			newUsuario.setName("Pedro");
			map.put("usuario", null);
		}
		
		body = frag.execute();
		compiler.compile("{{>nav}}").execute(map, out);
	}

}
