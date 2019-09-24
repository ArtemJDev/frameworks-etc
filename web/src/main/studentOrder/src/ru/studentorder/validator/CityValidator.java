package main.studentOrder.src.ru.studentorder.validator;

import ru.studentorder.domain.AnswerCityRegister;
import ru.studentorder.domain.Person;
import ru.studentorder.domain.StudentOrder;

public class CityValidator {

  public String hostName;
  public int port;
  public String login;
  public String password;

  private CityRegisterChecker personChecker;

  public CityValidator() {
    personChecker = new FakeCityRegisterChecker();
  }

  public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
    Person p = studentOrder.getHusband();
    personChecker.checkPerson(studentOrder.getHusband());
    personChecker.checkPerson(studentOrder.getWife());
    personChecker.checkPerson(studentOrder.getChild());

    AnswerCityRegister answerCityRegister = new AnswerCityRegister();
    return answerCityRegister;
  }
}
