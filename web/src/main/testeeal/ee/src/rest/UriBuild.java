package main.testeeal.ee.src.rest;

import java.net.URISyntaxException;
import javax.ws.rs.core.UriBuilder;

public class UriBuild {

  public static void main(String[] args) throws URISyntaxException {
//    URI FOR client use
    System.out.println(UriBuilder.fromUri("http://localhost:8080/").path("/sr").path("sayHelloWorld").toTemplate());

  }
}
