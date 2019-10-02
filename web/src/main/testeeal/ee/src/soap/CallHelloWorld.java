package main.testeeal.ee.src.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class CallHelloWorld {

  public static void main(String[] args) throws MalformedURLException {
     URL url = new URL("http://localhost:8080/sayHelloWorld");

     QName qname = new QName("http://soap/","HelloWorldExampleImplService");

     Service service = Service.create(url,qname);

     HelloWorldExample helloWorldExample = service.getPort(HelloWorldExample.class);

     System.out.println(helloWorldExample.sayHello());

  }
}
