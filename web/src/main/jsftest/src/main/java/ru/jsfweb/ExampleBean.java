package main.jsftest.src.main.java.ru.jsfweb;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named
public class ExampleBean {
private String name;

  @PostConstruct
  private void initialize() {
    name = "initializate";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void someAction() {
    name = " ";
  }
}
