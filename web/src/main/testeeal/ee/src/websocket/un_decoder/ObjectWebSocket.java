package main.testeeal.ee.src.websocket.un_decoder;

import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/objectMessage", decoders = MyMessageDecoder.class, encoders = MyMessageEncoder.class)
public class ObjectWebSocket {

  @OnMessage
  public void onMessage(Session session, Message msg) throws EncodeException {
    try {
      msg.getMsg();
      session.getBasicRemote().sendObject( msg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
