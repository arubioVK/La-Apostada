package apostada.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class CSRFHandlerConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CSRFHandlerInterceptor());
	}
	
}

class CSRFHandlerInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
		// A veces "modelAndView" es null cuando no encuentra la pagina
		if (modelAndView != null) {
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			modelAndView.addObject("_csrf", token);
		}
		
	}
	
}
