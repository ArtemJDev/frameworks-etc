package main.itv.jsfPractice.java.validate;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import sun.security.validator.ValidatorException;

@ManagedBean
public class StudentValidFour {

  String name;
  String lastName;
  String courseCode;

  public StudentValidFour() {
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
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

  public void validateCorseCode(FacesContext context, UIComponent component, Object value)
      throws ValidatorException {
    if(value == null) {
      return;
    }
    String data = value.toString();
    //CourseCode must start with LUV
    if(!data.startsWith("My")) {
      FacesMessage message = new FacesMessage("CourseCode must start with LUV");
      throw new ValidatorException(message);
    }
  }
}
