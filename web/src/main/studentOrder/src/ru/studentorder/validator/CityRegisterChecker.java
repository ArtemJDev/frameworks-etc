package main.studentOrder.src.ru.studentorder.validator;

import ru.studentorder.domain.CityRegisteCheckerResponce;
import ru.studentorder.domain.Person;

public interface CityRegisterChecker {
   CityRegisteCheckerResponce checkPerson(Person person);
}
