package main.testeeal.ee.src.rest;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

@Path("/context")
public class ContextR {


  @Context
  UriInfo uriInfo;

  @GET
  @Produces("text/plain") //производим отдаем - возвращаемый тип
  @Consumes(MediaType.TEXT_PLAIN) //принимаем тип
  @Path("/get")
  //@Consumes("text/html") //принимаем
  public String getException() {
//    throw new RuntimeException("easy exc");
    throw new RuntimeException("Responce Exception");
  }

  @PUT
  // @Path("/put") // sayHelloWorld/put вложенность
  @Produces("text/plain") //производим отдаем
  public String getExceptionChecked() throws IOException {
    throw new IOException("easy exc");
  }

  @Provider
  class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
    public Response toResponse(RuntimeException e) {
      return Response.status(404).entity(e.getMessage()).type(MediaType.TEXT_PLAIN).build();
    }
  }

  @GET
  @Produces("text/plain") //производим отдаем - возвращаемый тип
  @Consumes(MediaType.TEXT_PLAIN) //принимаем тип
  //@Consumes("text/html") //принимаем
  public String getContext(@Context HttpHeaders httpHeaders, @Context Request request, @Context
      Providers providers,@Context SecurityContext securityContext) {
    return uriInfo.getAbsolutePath().toString();
  }

  @PUT
  // @Path("/put") // sayHelloWorld/put вложенность
  @Produces("text/plain") //производим отдаем
  public String putString() {
    return "Hello from PUT";
  }
}
