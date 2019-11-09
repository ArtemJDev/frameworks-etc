package main.testeeal.ee.src.websocket;

import java.io.IOException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/paramWS/{param}")
public class WSServerParam {

  @OnMessage
  public void onMessage(Session session, String msg, @PathParam("param") String param) {
    try {
      System.out.println(msg);
      System.out.println(param);
      session.getBasicRemote().sendText(param);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
