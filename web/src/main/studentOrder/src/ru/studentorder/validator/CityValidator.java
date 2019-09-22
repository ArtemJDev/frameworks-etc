package main.studentOrder.src.ru.studentorder.validator;

import ru.studentorder.domain.AnswerCityRegister;
import ru.studentorder.domain.StudentOrder;

public class CityValidator {

  public String hostName;
  public int port;
  public String login;
  public String password;

  public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
    System.out.println("City Registry Is Running: " + hostName + " , " + login + " , " + password);
    AnswerCityRegister answerCityRegister = new AnswerCityRegister();
    return answerCityRegister;
  }
}
