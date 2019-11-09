package main.testeeal.ee.src.CDI;

public class Child implements Parent {

  @Override
  public void print() {
    System.out.println("From child");
  }
}
