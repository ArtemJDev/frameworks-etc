package main.itv.jsfPractice.java.servlets.students;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {

  String firstName;
  String lastName;

  public Student() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
