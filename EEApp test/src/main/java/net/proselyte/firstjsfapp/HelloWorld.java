package net.proselyte.firstjsfapp;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld1", eager = true)
public class HelloWorld {
  public HelloWorld() {
    System.out.println("HelloWorld started!");
  }

  public String getMessage() {
    return "Hell1o World!";
  }
}
