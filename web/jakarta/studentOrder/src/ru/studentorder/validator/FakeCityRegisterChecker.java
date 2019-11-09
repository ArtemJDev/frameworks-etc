package main.studentOrder.src.ru.studentorder.validator;

import ru.studentorder.domain.CityRegisteCheckerResponce;
import ru.studentorder.domain.Person;
import ru.studentorder.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

  public CityRegisteCheckerResponce checkPerson(Person person) throws CityRegisterException {
    return null;
  }
}
