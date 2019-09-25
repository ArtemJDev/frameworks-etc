package main.testeeal.ee.src.ejb;

import javax.ejb.Asynchronous;
import javax.inject.Singleton;

@Singleton
@Asynchronous
public class AsyncEjb {

  public void getName() {
    Thread.sleep(100);
  }
}
