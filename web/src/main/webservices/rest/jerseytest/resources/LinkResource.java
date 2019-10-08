package main.webservices.rest.jerseytest.resources;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

//my.site.com/api/links
@Path("links")
public class LinkResource {

  private static final AtomicInteger currentId = new AtomicInteger();
  private static final Map<String, String> links = new ConcurrentHashMap<String, String>();

  @GET
  @Produces(MediaType.TEXT_PLAIN) //string
  @Path("{id}") //my.site.com/api/links/{id}
  public Response getUrlById(final @PathParam("id") String id) {
      if( id == null || id.isEmpty() ) {
        return Response.status(Status.NOT_FOUND).build();
      }
      final String url = links.get(id);
      if(url == null) {
        return Response.status(Status.NOT_FOUND).build();
      }
      return Response.ok(url).build();
  }

  @PUT //если нет pathбудет по классу //my.site.com/api/links
  @Consumes(MediaType.TEXT_PLAIN) //http запрос должен передовать string
  @Produces(MediaType.TEXT_PLAIN) // отдавать string
  public Response shortUrl(final String requestDoc) {
   final int id = currentId.getAndIncrement();
   links.put(String.valueOf(id), requestDoc.toString());
   return Response.ok(id).build();
  }



}
