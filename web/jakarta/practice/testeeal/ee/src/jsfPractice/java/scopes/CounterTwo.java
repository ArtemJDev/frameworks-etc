package main.itv.jsfPractice.java.scopes;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class CounterTwo {

  private int value = 0;

  public String increment() {
    value++;
    return "counter_two";
  }

  public CounterTwo() {

  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
