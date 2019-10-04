package main.testeeal.ee.src.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/sayHelloWorld")
public class HelloWorld {

    @GET
    @Produces("text/plain") //производим отдаем
    //@Consumes("text/html") //принимаем
    public String sayHello() {
      return "Hello from GET";
  }

    @PUT
   // @Path("/put") // sayHelloWorld/put вложенность
    @Produces("text/plain") //производим отдаем
    public String putString() {
      return "Hello from PUT";
  }
}
