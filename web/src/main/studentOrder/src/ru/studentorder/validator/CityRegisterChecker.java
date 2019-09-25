package main.studentOrder.src.ru.studentorder.validator;

import ru.studentorder.domain.CityRegisteCheckerResponce;
import ru.studentorder.domain.Person;
import ru.studentorder.exception.CityRegisterException;

public interface CityRegisterChecker {
   CityRegisteCheckerResponce checkPerson(Person person) throws CityRegisterException ;
}
