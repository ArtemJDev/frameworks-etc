package main.itv.jsfPractice.java.students;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentManyCheckBox {
  String firstName;
  String lastName;

  String[] favoriteLanguage;

  public StudentManyCheckBox() {
  }

  public String[] getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public void setFavoriteLanguage(String[] favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
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
