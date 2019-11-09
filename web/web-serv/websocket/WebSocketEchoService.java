package main.testeeal.ee.src.websocket;

import java.io.IOException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler.Whole;
import javax.websocket.Session;

public class WebSocketEchoService extends Endpoint {

  @Override
  public void onOpen(Session session, EndpointConfig endpointConfig) {
    session.addMessageHandler(new Whole<String>() {
      @Override
      public void onMessage(String o) {
        System.out.println(o);
        try {
          session.getBasicRemote().sendText("You have send:" + o);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
