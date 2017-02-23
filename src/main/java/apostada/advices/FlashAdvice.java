package apostada.advices;

import apostada.servicios.FlashService;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class FlashAdvice {

	private final Mustache.Compiler compiler;

	@Autowired
	private FlashService flashService;
	
	@Autowired
	public FlashAdvice(Mustache.Compiler compiler) {
		this.compiler = compiler;
	}

	@ModelAttribute("flash")
	public Mustache.Lambda flash(Map<String, Object> model) {
		return new Flash(compiler, flashService);
	}
	
}

class Flash implements Mustache.Lambda {

	public String body;

	private final Mustache.Compiler compiler;
	private final FlashService flashService;
	
	public Flash(Mustache.Compiler compiler, FlashService flashService) {
		this.compiler = compiler;
		this.flashService = flashService;
	}

	@Override
	public void execute(Template.Fragment frag, Writer out) throws IOException {
		Map<String, Object> map = (Map<String, Object>) frag.context();
		
		if (flashService.getSuccess() != null) {
			map.put("success", flashService.getSuccess());
			flashService.setSuccess(null);
		} else if (flashService.getError() != null) {
			map.put("error", flashService.getError());
			flashService.setError(null);
		}
		
		body = frag.execute();
		compiler.compile("{{>flash}}").execute(map, out);
	}

}
