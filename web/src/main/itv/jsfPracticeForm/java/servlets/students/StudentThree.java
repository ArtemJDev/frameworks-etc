package main.itv.jsfPracticeForm.java.servlets.students;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentThree {

  String firstName;
  String lastName;
  String favoriteLamguage;

  public StudentThree() {
  }


  public String getFavoriteLamguage() {
    return favoriteLamguage;
  }

  public void setFavoriteLamguage(String favoriteLamguage) {
    this.favoriteLamguage = favoriteLamguage;
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
