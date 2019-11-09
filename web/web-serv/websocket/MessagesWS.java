package main.testeeal.ee.src.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/messagesWS")
public class MessagesWS {

  @OnOpen
  public void onOpen(Session session) {
    System.out.println("Connection open on server");
  }

  @OnMessage
  public void OnMessage(Session session , String str) throws IOException {
    System.out.println(str);
    session.getBasicRemote().sendText("You have send " + str);
  }
  @OnMessage
  public void OnMessageByte(Session session , ByteBuffer str) throws IOException {
    System.out.println(str);
    session.getBasicRemote().sendBinary(str);
  }
  @OnMessage
  public void OnMessagePong(Session session , PongMessage str) throws IOException {
  }



  @OnError
  public void OnError(Session session , Throwable throwable) throws IOException {
    throwable.printStackTrace();
  }

  @OnClose
  public void OnClose(Session session) throws IOException {
    System.out.println("server connection is closed");
  }
}
