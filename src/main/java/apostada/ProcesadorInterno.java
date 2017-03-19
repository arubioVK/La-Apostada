package apostada;

import org.springframework.stereotype.Component;

@Component
public class ProcesadorInterno implements Runnable {

	@Override
	public void run() {
		System.out.println("=> Iniciando comunicacion con el servicio interno");
		
		String destUri = "ws://echo.websocket.org";

		/*WebSocketClient client = new WebSocketClient();
        SimpleEchoSocket socket = new SimpleEchoSocket();
        try {
            client.start();

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(socket,echoUri,request);
            System.out.printf("Connecting to : %s%n",echoUri);

            // wait for closed socket connection.
            socket.awaitClose(5,TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
	}
	
}
