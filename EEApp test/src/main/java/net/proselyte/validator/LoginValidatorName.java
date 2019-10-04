package net.proselyte.validator;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("userNameValidator")
public class LoginValidatorName implements Validator {

  public LoginValidatorName() {
  }
  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent, Object o)
      throws ValidatorException {

    String newValue = o.toString();
    if(newValue.length()<5) {
      FacesMessage msg = new FacesMessage("UserName validation failed",
          "Имя не должно быть меньше 5 букв");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
    if(!Character.isLetter(newValue.charAt(0))) {
      FacesMessage msg = new FacesMessage("UserName FirstLetter validation failed",
          "UserName должен начинаться сбуквы");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
    if(getTestArray().contains(newValue)) {
      FacesMessage msg = new FacesMessage("UserName SAME validation failed",
          "Это имя уже использовано");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
//лучше делать через try catch
  }
  private ArrayList<String> getTestArray() {
    ArrayList<String> list = new ArrayList<>();
    list.add("username");
    list.add("login");
    return list;
  }
}
