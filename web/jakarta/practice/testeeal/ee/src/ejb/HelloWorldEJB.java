package main.testeeal.ee.src.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldEJB {

  public String HelloWorld() {
    return "Hello from ejb";
  }

}
