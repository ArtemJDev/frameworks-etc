package main.testeeal.ee.src.rest.providers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import rest.entity.Student;

@Provider
@Produces("my/format")
public class CustomStudentWriter implements MessageBodyWriter<Student> {

  public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations,
      MediaType mediaType) {
    return Student.class.isAssignableFrom((Class<?>) type);
  }

  public long getSize(Student student, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return student.getName().length() + 1 + student.getName().length();
  }

  public void writeTo(Student student, Class<?> aClass, Type type, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream)
      throws IOException, WebApplicationException {
    outputStream.write(student.getName().getBytes());
    outputStream.write('/');
    outputStream.write(student.getName().getBytes());
  }
}
