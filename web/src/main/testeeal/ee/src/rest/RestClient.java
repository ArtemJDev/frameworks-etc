package main.testeeal.ee.src.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestClient {

  public static void main(String[] args) throws URISyntaxException, IOException {
    URI uri = new URI("http://localhost:8080/rs/sayHelloWorld");

    HttpClient client = new DefaultHttpClient();
    HttpGet reqquest = new HttpGet(uri);

//    Client client = ClientBuilder.newClient();
//    WebTarget target = client.target(uri);
    HttpResponse response = client.execute(reqquest);

    if(response.getStatusLine().getStatusCode() == 200) {
      BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
      String line = "";
      while ((line = rd.readLine()) != null) {
        System.out.println(line);
      }
    }



//    Invocation invocation = target.request().buildGet();
//    Response response = invocation.invoke();//вызов запроса
//
//    if(response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode()) {
//      System.out.println( response.readEntity(String.class));
//    }
//
//    client.close();
  }
}
