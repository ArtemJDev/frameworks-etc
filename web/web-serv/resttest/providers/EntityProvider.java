package main.testeeal.ee.src.rest.providers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.entity.Student;

@Path("/entityProvider")
public class EntityProvider {
  @GET
  @Produces("my/format")
  public Student getCustomStudent() {
    return new Student("Max");
  }
  @POST
  @Consumes("my/formst")
  @Path("/getName/")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCustomStudent(Student student) {
    return  student.getName();
  }
}
