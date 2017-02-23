package apostada.servicios;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlashService {

	@Autowired
	HttpSession httpSession;
	
	public String getSuccess() {
		return (String) httpSession.getAttribute("success");
	}
	
	public void setSuccess(String message) {
		httpSession.setAttribute("success", message);
	}
	
	public String getError() {
		return (String) httpSession.getAttribute("error");
	}
	
	public void setError(String message) {
		httpSession.setAttribute("error", message);
	}
	
}
