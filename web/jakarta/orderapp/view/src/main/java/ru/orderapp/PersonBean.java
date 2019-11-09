package main.orderapp.view.src.main.java.ru.orderapp;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import ru.orderapp.ejb.AuthenticateBean;
import ru.orderapp.ejb.AuthenticateBean.LoginResult;

@Named
@SessionScoped
public class PersonBean implements Serializable {

  private String login;
  private String password;
  private boolean authenticated;
  private String initialRequestURL;


  @EJB
  private AuthenticateBean authenticateBean;

  public String getLogin() {
    return login;
  }

  public String getInitialRequestURL() {
    return initialRequestURL;
  }

  public void setInitialRequestURL(String initialRequestURL) {
    this.initialRequestURL = initialRequestURL;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isAuthenticated() {
    return authenticated;
  }

  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }

  public void doLogin() {
    authenticated = (authenticateBean.doLogin(login,password) == LoginResult.SUCESS);
    try {
        FacesContext.getCurrentInstance().getExternalContext().redirect(initialRequestURL);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
