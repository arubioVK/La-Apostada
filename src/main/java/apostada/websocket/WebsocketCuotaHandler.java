package apostada.websocket;

import apostada.entidades.Apuesta;
import apostada.servicios.ApuestaService;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebsocketCuotaHandler extends TextWebSocketHandler {

	@Autowired
	ApuestaService apuestaService;
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("WS received: " + message.getPayload());
		
		JSONObject obj;
		try {
			obj = new JSONObject(message.getPayload());
		} catch (JSONException ignored) {
			System.out.println("ERROR");
			return;
		}
		
		List<Apuesta> apuestas = apuestaService.findByFechaGreaterThanOrderByFechaAsc(new Date(obj.getString("last_view_timestamp")));
		
		for (Apuesta aux : apuestas) {
			session.sendMessage(new TextMessage("{"
					+ " \"partido_id\": " + aux.getPartido().getId() + ","
					+ " \"cuota\": {"
						+ " \"local\": " + aux.getPartido().getCuotaLocal()  + ","
						+ " \"empate\": " + aux.getPartido().getCuotaEmpate()  + ","
						+ " \"visitante\": " + aux.getPartido().getCuotaVisitante()
					+ " },"
					+ " \"fecha\": \"" + aux.getFecha().toString()  + "\""
					+ "}"));
		}
	}
	
}
