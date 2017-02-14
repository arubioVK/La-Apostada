package apostada.advices;

import apostada.servicios.SessionService;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class NavAdvice {

	private final Mustache.Compiler compiler;

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	public NavAdvice(Mustache.Compiler compiler) {
		this.compiler = compiler;
	}

	@ModelAttribute("nav")
	public Mustache.Lambda nav(Map<String, Object> model) {
		return new Nav(compiler, sessionService);
	}

}

class Nav implements Mustache.Lambda {
	
	String body;

	private Mustache.Compiler compiler;
	private SessionService sessionService;

	public Nav(Mustache.Compiler compiler, SessionService sessionService) {
		this.compiler = compiler;
		this.sessionService = sessionService;
	}

	@Override
	public void execute(Template.Fragment frag, Writer out) throws IOException {
		Map<String, Object> map = (Map<String, Object>) frag.context();
		
		map.put("usuario", sessionService.getUsuarioActual());
		
		body = frag.execute();
		compiler.compile("{{>nav}}").execute(map, out);
	}

}
