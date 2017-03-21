package apostada;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {

		URL url = ((URLClassLoader) Application.class.getClassLoader()).getURLs()[0];
		String str = url.toString();
		int ind = str.lastIndexOf("!");
		if (ind >= 0) {
			str = new StringBuilder(str).replace(ind, ind + 1, "").toString();
		}
		
		System.out.println(URLDecoder.decode(str + "truststore.jks", "UTF-8"));
		
		// Setear certificado para el servicio interno
		//System.setProperty("javax.net.ssl.trustStore", str + "truststore.jks");
		//System.setProperty("javax.net.ssl.trustStorePassword", "password");
		
		// Empezar servidor web
		SpringApplication.run(Application.class, args);
	}

}
