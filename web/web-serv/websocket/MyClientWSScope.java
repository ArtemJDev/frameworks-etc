package main.testeeal.ee.src.websocket;

import java.io.IOException;
import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class MyClientWSScope {
  @OnOpen
  public void onOpen(Session session) {
    System.out.println("Connection open on client");
  }

  @OnMessage
  public void OnMessage(Session session , String str) throws IOException {
    System.out.println("you have send " + str);
  }

  @OnError
  public void OnError(Session session , Throwable throwable) throws IOException {
    throwable.printStackTrace();
  }

  @OnClose
  public void OnClose(Session session) throws IOException {
    System.out.println("client connection is closed");

  }

  public static void main(String[] args)
      throws IOException, DeploymentException, InterruptedException {
    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    Session session = container
        .connectToServer(MyClientWSScope.class, URI.create("ws://localhost:8080/messagesWS"));
    session.getBasicRemote().sendText("Hello World");
    Thread.sleep(1000);
  }
}