package apostada;

import java.net.URLDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		// Setear certificado para el servicio interno
		System.setProperty("javax.net.ssl.trustStore", URLDecoder.decode(Application.class.getClass().getResource("/truststore.jks").getPath(), "UTF-8"));
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		
		// Empezar servidor web
		SpringApplication.run(Application.class, args);
	}

}
