package net.proselyte.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.jmx.export.annotation.ManagedNotification;

@ManagedBean
@RequestScoped
public class LoginController {

  public LoginController() {

  }

  public String login() {
    return "response";
  }
}
