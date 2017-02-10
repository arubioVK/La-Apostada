package apostada.advices;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template.Fragment;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
class LayoutAdvice {

	private final Mustache.Compiler compiler;

	@Autowired
	public LayoutAdvice(Mustache.Compiler compiler) {
		this.compiler = compiler;
	}

	@ModelAttribute("layout")
	public Mustache.Lambda layout(Map<String, Object> model) {
		return new Layout(compiler);
	}

	@ModelAttribute("title")
	public Mustache.Lambda title(@ModelAttribute Layout layout) {
		return (frag, out) -> {
			layout.title = frag.execute() + " | " + layout.title;
		};
	}

}

class Layout implements Mustache.Lambda {

	String body;

	String title = "La Apostada";

	private Mustache.Compiler compiler;

	public Layout(Mustache.Compiler compiler) {
		this.compiler = compiler;
	}

	@Override
	public void execute(Fragment frag, Writer out) throws IOException {
		body = frag.execute();
		compiler.compile("{{>layout}}").execute(frag.context(), out);
	}

}
