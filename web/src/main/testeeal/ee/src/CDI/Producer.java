package main.testeeal.ee.src.CDI;

import javax.enterprise.inject.Produces;


public class Producer {

  @Produces
  Car getCar() {
    return new Car("Toyota");
  }

}
