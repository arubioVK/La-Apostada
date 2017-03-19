package apostada.controladores;

import apostada.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@ExceptionHandler(ResourceNotFoundException.class)
	@RequestMapping(value="/404", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFoundException() {
		return "404";
	}

	@RequestMapping(value="/403", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String accesssDenied(Model model) {
		return "403";
	}

}
