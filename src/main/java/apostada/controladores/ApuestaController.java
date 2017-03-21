package apostada.controladores;

import apostada.entidades.Apuesta;
import apostada.entidades.Partido;
import apostada.entidades.Usuario;
import apostada.servicios.FlashService;
import apostada.servicios.SessionService;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/apuesta")
public class ApuestaController {

	@Autowired
	private FlashService flashService;

	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(value="/apostar", method=RequestMethod.POST)
	public String apostar(Model model, @RequestParam Partido partido, @RequestParam double cuota,
			@RequestParam int resultado, @RequestParam double cantidad, @RequestParam String redirect) throws NoSuchAlgorithmException, KeyStoreException, KeyStoreException, KeyStoreException, KeyStoreException, KeyManagementException, KeyStoreException, KeyStoreException {
		Usuario usuario = sessionService.getUsuarioActual();
		
		if (usuario == null) {
			flashService.setError("Tienes que iniciar sesion");
		} else {
			Apuesta apuesta = new Apuesta(partido, usuario, cuota, cantidad, new Date(), resultado);
			
			String url = "https://localhost:8888/apuesta";

			String plainCreds = "usuario:secreto123456";
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			HttpEntity<Apuesta> httpEntity = new HttpEntity<>(apuesta, headers);
			
			// Quitar validacion SSL
			HttpsURLConnection.setDefaultHostnameVerifier(
					(String hostname, javax.net.ssl.SSLSession sslSession) -> {
				return true;
			});
			TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
			SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
						.loadTrustMaterial(null, acceptingTrustStrategy)
						.build();
			SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			requestFactory.setHttpClient(httpClient);

			RestTemplate restTemplate = new RestTemplate(requestFactory);
			ResponseEntity<Object> response = null;
			
			try {
				response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Object.class);
			} catch (HttpClientErrorException e) {
				flashService.setError(e.getResponseBodyAsString());
			}
			
			if (response != null) {
				flashService.setSuccess("Apuesta realizada correctamente");
			}
		}
		
		return "redirect:" + redirect;
	}
	
	static {
	    //for localhost testing only
	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				(String hostname, javax.net.ssl.SSLSession sslSession) -> {
			return true;
		});
	}
	
}
