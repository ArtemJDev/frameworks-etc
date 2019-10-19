package main.itv.jsfPractice.java.servlets.validate;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentValidTwo {

  String name;
  String lastName;
  int freePasses;
  String postalCode;

  public StudentValidTwo() {
  }

  public int getFreePasses() {
    return freePasses;
  }

  public void setFreePasses(int freePasses) {
    this.freePasses = freePasses;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
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
