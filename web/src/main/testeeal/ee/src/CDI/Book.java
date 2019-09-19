package main.testeeal.ee.src.CDI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;


public class Book {
  String name;
  public Book(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD,ElementType.PARAMETER})
  @interface Add{}

  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD,ElementType.PARAMETER})
  @interface Delete{}
}
