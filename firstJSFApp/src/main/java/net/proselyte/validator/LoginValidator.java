package net.proselyte.validator;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class LoginValidator implements Validator {

  private static final String EMAIL_PATTERN =
      "^[_A-Za-z0-9-]+(\\." +
          "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
          "(\\.[A-Za-z]{2,})$";
  private Pattern pattern;
  public LoginValidator() {
    pattern = Pattern.compile(EMAIL_PATTERN);
  }
  @Override
  public void validate(FacesContext context, UIComponent component,
      Object value) throws ValidatorException {
    Matcher matcher = pattern.matcher(value.toString());
    if (!matcher.matches()) {
      FacesMessage msg = new FacesMessage("E-mail validation failed.",
          "Invalid E-mail format.");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      throw new ValidatorException(msg);
    }
  }
}