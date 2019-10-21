package main.itv.jsfPractice.java.validate;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentValidOne {

  String name;
  String lastName;
  String email;

  public StudentValidOne() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
