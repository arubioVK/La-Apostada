package apostada.advices;

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
public class FlashAdvice {

	private final Mustache.Compiler compiler;

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	public FlashAdvice(Mustache.Compiler compiler) {
		this.compiler = compiler;
	}

	@ModelAttribute("flash")
	public Mustache.Lambda flash(Map<String, Object> model) {
		return new Flash(compiler, httpSession);
	}
	
}

class Flash implements Mustache.Lambda {

	String body;

	private Mustache.Compiler compiler;
	private HttpSession httpSession;
	
	public Flash(Mustache.Compiler compiler, HttpSession httpSession) {
		this.compiler = compiler;
		this.httpSession = httpSession;
	}

	@Override
	public void execute(Template.Fragment frag, Writer out) throws IOException {
		Map<String, Object> map = (Map<String, Object>) frag.context();
		if (httpSession.getAttribute("success") != null) {
			map.put("success", httpSession.getAttribute("success"));
			httpSession.setAttribute("success", null);
		} else if (httpSession.getAttribute("error") != null) {
			map.put("error", httpSession.getAttribute("error"));
			httpSession.setAttribute("error", null);
		}
		
		body = frag.execute();
		compiler.compile("{{>flash}}").execute(map, out);
	}

}
