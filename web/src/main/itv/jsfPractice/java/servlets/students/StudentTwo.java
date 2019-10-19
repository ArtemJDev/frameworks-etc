package main.itv.jsfPractice.java.servlets.students;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentTwo {

  String firstName;
  String lastName;
  String country;

  List<String> countryOptions;

  public StudentTwo() {
    countryOptions = new ArrayList<>();

    countryOptions.add("Brazil");
    countryOptions.add("France");
    countryOptions.add("Germany");
    countryOptions.add("India");
    countryOptions.add("Turkey");
    countryOptions.add("UK");
    countryOptions.add("USA");
  }

  public List<String> getCountryOptions() {
    return countryOptions;
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
