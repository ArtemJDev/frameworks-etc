package main.studentOrder.src.ru.studentorder.validator;

import ru.studentorder.domain.CityRegisteCheckerResponce;
import ru.studentorder.domain.Person;

public class FakeCityRegisterChecker implements CityRegisterChecker {

  public CityRegisteCheckerResponce checkPerson(Person person) {
    return null;
  }
}
