package main.testeeal.ee.src.websocket;

import java.io.IOException;
import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class ParameterClient {
  @OnMessage
  public void OnMessage(Session session, String s) {
    System.out.println("Client get message " + s );
  }


  public static void main(String[] args)
      throws IOException, DeploymentException, InterruptedException {
    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    Session session = container
        .connectToServer(ParameterClient.class, URI.create("ws://localhost:8080/paramWS/helloParam"));
    session.getBasicRemote().sendText("Hello World");
    Thread.sleep(1000);
  }
}
