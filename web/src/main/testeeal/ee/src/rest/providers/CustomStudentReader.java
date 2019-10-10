package main.testeeal.ee.src.rest.providers;


import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.StringTokenizer;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import rest.entity.Student;

@Provider
@Consumes("my/format")
public class CustomStudentReader implements MessageBodyReader<Student> {

  public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations,
      MediaType mediaType) {
    return Student.class.isAssignableFrom((Class<?>) type);
  }

  public Student readFrom(Class<Student> aClass, Type type, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream)
      throws IOException, WebApplicationException {
    String str= inputStream.toString();
    StringTokenizer s = new StringTokenizer(str, "/") ;
    Student student = new Student();
    student.setName(s.nextToken());
    return student;
  }
}
