package main.testeeal.ee.src.rest;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class RestClient {

  public static void main(String[] args) throws URISyntaxException {
    URI uri = new URI("http://localhost:8080/rs/sayHelloWorld");
    //создаем нового клиента
    Client client = ClientBuilder.newClient();

    //цель на которую будем стучаться
    WebTarget target = client.target(uri);
    //посылаем get запрос (определяем тип запроса)
    Invocation invocation = target.request().buildPut(Entity.text("gogogo"));
    //вызываем запрос и получаем информацию
    Response response = invocation.invoke();

    //проверяем статус
    if(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode()) {
      System.out.println(response.readEntity(String.class));
    }

//    client.target(uri).request().get(String.class);

    client.close();

  }
}
