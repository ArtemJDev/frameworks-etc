package main.testeeal.ee.src.websocket.un_decoder;

import java.io.IOException;
import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint(decoders = MyMessageDecoder.class, encoders = MyMessageEncoder.class)
public class MyClientDecoder {

  @OnMessage
  public void OnMessage(Session session, Message s) {
    System.out.println("Client get message " + s.getMsg() );
  }


  public static void main(String[] args)
      throws IOException, DeploymentException, InterruptedException, EncodeException {
    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    Session session = container
        .connectToServer(MyClientDecoder.class, URI.create("ws://localhost:8080/objectMessage"));
    session.getBasicRemote().sendObject(new Message("Hello world"));
    Thread.sleep(1000);
  }
}
