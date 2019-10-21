package main.itv.jsfPractice.java.lists;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {

  private String name;
  private String lasName;
  private String email;

  public Student(String name, String lasName, String email) {
    this.name = name;
    this.lasName = lasName;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLasName() {
    return lasName;
  }

  public void setLasName(String lasName) {
    this.lasName = lasName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
