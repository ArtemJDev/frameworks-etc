package main.testeeal.ee.src.CDI;

import javax.inject.Inject;

public class ChangeMyBean {
  @Inject
  Mybean mybean;

  public void changeI() {
    mybean.i = 2;
  }
}
