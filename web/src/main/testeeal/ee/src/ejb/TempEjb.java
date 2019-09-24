package main.testeeal.ee.src.ejb;

import javax.ejb.Stateless;

@Stateless
public class TempEjb {
  int i;

  public void print() {
    i=5;
    System.out.println("Hello from");
  }

  public int getI() {
    return i;
  }


}
