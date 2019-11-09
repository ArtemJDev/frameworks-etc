package main.testeeal.ee.src.soap;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "soap.HelloWorldExample")
public class HelloWorldExampleImpl implements HelloWorldExample {

@Override
  public String sayHello() {
    return "Hello World";
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/sayHelloWorld",new HelloWorldExampleImpl());
  }
}
