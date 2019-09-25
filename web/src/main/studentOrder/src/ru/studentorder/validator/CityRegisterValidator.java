package main.studentOrder.src.ru.studentorder.validator;

import ru.studentorder.domain.AnswerCityRegister;
import ru.studentorder.domain.CityRegisteCheckerResponce;
import ru.studentorder.domain.Person;
import ru.studentorder.domain.StudentOrder;
import ru.studentorder.exception.CityRegisterException;

public class CityRegisterValidator {

  public String hostName;
  public int port;
  public String login;
  public String password;

  private CityRegisterChecker personChecker;

  public CityRegisterValidator() {
    personChecker = new FakeCityRegisterChecker();
  }

  public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
    Person p = studentOrder.getHusband();
    try{
      CityRegisteCheckerResponce hans = personChecker.checkPerson(studentOrder.getHusband());
      CityRegisteCheckerResponce wans = personChecker.checkPerson(studentOrder.getWife());
      CityRegisteCheckerResponce cans = personChecker.checkPerson(studentOrder.getChild());
    } catch (CityRegisterException e) {
      e.printStackTrace();
    }
    

    AnswerCityRegister answerCityRegister = new AnswerCityRegister();
    return answerCityRegister;
  }
}
