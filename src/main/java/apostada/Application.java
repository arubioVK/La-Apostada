package apostada;

import apostada.messages.ApuestaDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static final String INTERNAL_SERVER_IP = "127.0.0.1";
	public static final int INTERNAL_SERVER_PORT = 8888;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		
		System.setProperty("javax.net.ssl.trustStore", URLDecoder.decode(Application.class.getClass().getResource("/truststore.jks").getPath(), "UTF-8"));
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		
		// Cliente para comunicarse con el interno
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket sslsocket = (SSLSocket) factory.createSocket(INTERNAL_SERVER_IP, INTERNAL_SERVER_PORT);

		ObjectOutputStream out = new ObjectOutputStream(sslsocket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(sslsocket.getInputStream());
		
		out.writeObject(new ApuestaDTO());
		out.flush();
	}

}
