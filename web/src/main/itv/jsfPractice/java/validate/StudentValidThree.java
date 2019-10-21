package main.itv.jsfPractice.java.validate;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentValidThree {

  String name;
  String lastName;
  String phoneNumber;

  public StudentValidThree() {
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
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
