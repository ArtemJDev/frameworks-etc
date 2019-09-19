package main.testeeal.ee.src.CDI;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class MyDecorator implements Parent {

  @Inject
  @Delegate
  Parent parent;

  @Override
  public void print() {
    System.out.println("Before print");
    parent.print();
    System.out.println("after print");

  }
}
