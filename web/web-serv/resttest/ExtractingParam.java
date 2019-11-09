package main.testeeal.ee.src.rest;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/extract")
@Produces("text/plain") //возвращают текс
public class ExtractingParam {

  @GET
  @Path("/{id}")
  public String returnId(@PathParam("id") String id) {
    return id;
  }

  @GET
  @Path("/id/{id}")
  public String returnById(@PathParam("id") String id) {
    return "id = " + id;
  }

  @GET
  @Path("userName/{name: [a-zA-Z]*}")
  public String getName(@PathParam("name") String name) {
    return "Name is = " + name;
  }

  @GET
  @Path("/age/")
  public String getAge(@QueryParam("userAge") int userAge) {
    return "User age  is = " + userAge;
  }

  @GET
  @Path("/city/")
  public String getCity(@DefaultValue("Moscow") @MatrixParam("userCity") String city) {
    return "Cit  is = " + city;
  }

  @GET
  @Path("/sessionId/")
  public String extractSessionId(@DefaultValue("null") @CookieParam("sessionId") String sessionId) {
    return "SessionId  is = " + sessionId;
  }

  @GET
  @Path("/userAgent")
  public String extractUserAgent(@HeaderParam("User-Agent") String userAgent) {
    return userAgent;
  }

  @POST
  @Path("/form")
  public String extractForm(@FormParam("test")  String test) {
    return "test value  is = " + test;
  }


}
