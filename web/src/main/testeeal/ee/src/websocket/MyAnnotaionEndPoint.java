package main.testeeal.ee.src.websocket;

import java.io.IOException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myEndPoint")
public class MyAnnotaionEndPoint {
  @OnMessage
  public void onMessage(Session session, String msg) {
    try {
      session.getBasicRemote().sendText("You have send " + msg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
