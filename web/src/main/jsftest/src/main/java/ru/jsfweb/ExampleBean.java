package main.jsftest.src.main.java.ru.jsfweb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ExampleBean implements Serializable {
private String name;

  @PostConstruct
  private void initialize() {
    name = "Hello";
  }

  public String getName() {
    return name;
  }

  @Lock(LockType.WRITE)
  public void setName(String name) {
    this.name = name;
  }

  public void someAction() {
    name = " ";
  }
}
