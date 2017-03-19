package apostada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) throws Exception {
		// Empezar servidor web
		SpringApplication.run(Application.class, args);
		
		// Comunicacion con el servicio interno
		Thread procesadorInterno = new Thread(new ProcesadorInterno());
		procesadorInterno.start();
	}

}
