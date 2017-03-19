package apostada.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebsocketCuotaHandler extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("WS received: " + message.getPayload());
		//String msg = message.getPayload();
		session.sendMessage(new TextMessage("{\"type\": 1, \"partido_id\": 31, \"cuota\": { \"local\": 1.02, \"empate\": 2.5, \"visitante\": 3.2 }}"));
	}
	
}
