package main.testeeal.ee.src.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rest.entity.Student;

@Path("/sayHelloWorld")
public class HelloWorld {

    @GET
    @Produces("text/plain") //производим отдаем - возвращаемый тип
    @Consumes(MediaType.TEXT_PLAIN) //принимаем тип
    //@Consumes("text/html") //принимаем
    public String sayHello() {
      return "Hello from GET";
  }

    @GET
    @Path("/long")
    @Produces("text/plain") // отдаем - возвращаемый тип
    @Consumes(MediaType.TEXT_PLAIN) //принимаем тип
    public Long returnLong() {
      return 1225l;
    }

  @GET
  @Path("/ObjectToXml")
  @Produces(MediaType.APPLICATION_XML) // отдаем - возвращаемый тип
  @Consumes(MediaType.TEXT_PLAIN) //принимаем тип
  public Student returnObjectAsXML() {
    return new Student("Max");
  }

  @GET
  @Path("/ObjectToJSON")
  @Produces(MediaType.APPLICATION_JSON) // отдаем - возвращаемый тип
  @Consumes(MediaType.TEXT_PLAIN) //принимаем тип
  public Response returnObjectAsJSON() {
    return Response.ok(new Student("Max"), MediaType.APPLICATION_JSON).build();
  }

    @PUT
   // @Path("/put") // sayHelloWorld/put вложенность
    @Produces("text/plain") //производим отдаем
    public String putString() {
      return "Hello from PUT";
  }
}
