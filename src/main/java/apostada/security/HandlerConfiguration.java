package apostada.security;

import apostada.servicios.SessionService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class HandlerConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	SessionService sessionService;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor(sessionService));
	}
	
}

class HandlerInterceptor extends HandlerInterceptorAdapter {
	
	private final SessionService sessionService;
	
	public HandlerInterceptor(SessionService sessionService) {
		super();
		
		this.sessionService = sessionService;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
		// A veces "modelAndView" es null cuando no encuentra la pagina
		if (modelAndView != null) {
			// CSRF
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			modelAndView.addObject("_csrf", token);
			
			// User role
			if (sessionService.getUsuarioActual() != null) {
				modelAndView.addObject("isAdmin", sessionService.usuarioActualHasRole("ROLE_ADMIN"));
			}
		}
		
	}
	
}