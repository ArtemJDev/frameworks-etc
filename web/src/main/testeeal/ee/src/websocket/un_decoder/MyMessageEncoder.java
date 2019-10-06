package main.testeeal.ee.src.websocket.un_decoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MyMessageEncoder implements Encoder.Text<Message> {

  @Override
  public String encode(Message object) throws EncodeException {
    return object.getMsg();
  }

  @Override
  public void init(EndpointConfig config) {

  }

  @Override
  public void destroy() {

  }
}
