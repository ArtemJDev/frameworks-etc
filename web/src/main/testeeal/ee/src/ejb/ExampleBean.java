package main.testeeal.ee.src.ejb;

import ejb.Interfaces.LocalExampleInterfaces;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ExampleBean implements LocalExampleInterfaces {

  @Override
  public String getName() {
    return "Max";
  }

  public String getSerName() {
    return "Black";
  }
}
