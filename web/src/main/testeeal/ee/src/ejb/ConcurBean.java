package main.testeeal.ee.src.ejb;

import java.util.concurrent.TimeUnit;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
@Lock(LockType.READ)
@AccessTimeout(value = 20, unit = TimeUnit.MINUTES)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ConcurBean {

  int i;

  public int getI() {
    return i;
  }

  public int setI(int i) {

    return this.i = i;
  }

  public int incremI() {
    return ++i;
  }


}
