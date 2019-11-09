package main.testeeal.ee.src.websocket.un_decoder;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MyMessageDecoder implements Decoder.Text<Message>{

  @Override
  public Message decode(String s) throws DecodeException {
    return new Message(s);
  }

  @Override
  public boolean willDecode(String s) {
    return true;
  }

  @Override
  public void init(EndpointConfig config) {

  }

  @Override
  public void destroy() {

  }
}
