package main.studentOrder.src.ru.studentorder.mail;


import ru.studentorder.domain.AnswerChilren;
import ru.studentorder.domain.AnswerCityRegister;
import ru.studentorder.domain.AnswerStudent;
import ru.studentorder.domain.AnswerWedding;
import ru.studentorder.domain.StudentOrder;
import ru.studentorder.validator.ChildrenValidator;
import ru.studentorder.validator.CityValidator;
import ru.studentorder.validator.StudentValidator;
import ru.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {

  public static void main(String[] args) {
    checkAll();
  }

  static void checkAll() {

    while (true) {
      StudentOrder studentOrder = readStudentOrder();

      if (studentOrder == null) {
        break;
      } else {
        AnswerCityRegister answerCityRegister = checkCityRegister(studentOrder);
        if(!answerCityRegister.success) {
            break;
        }
        AnswerChilren answerChilren = checkChildren(studentOrder);
        AnswerStudent answerStudent = checkStudent(studentOrder);
        AnswerWedding answerWedding = checkWedding(studentOrder);
        sendMail(studentOrder);
      }
    }
  }

  static StudentOrder readStudentOrder() {
    StudentOrder studentOrder = new StudentOrder();
    return  studentOrder;
  }

  static void sendMail(StudentOrder studentOrder) {
    System.out.println("Mail sent");

  }

  static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
    CityValidator cityValidator = new CityValidator();
    cityValidator.hostName = "Host1";
    cityValidator.login = "login1";
    cityValidator.password = "passwqord1";

    AnswerCityRegister answerCityRegister1 = cityValidator.checkCityRegister(studentOrder);

    return answerCityRegister1;
  }

  public static AnswerWedding checkWedding(StudentOrder studentOrder) {
    WeddingValidator weddingValidator = new WeddingValidator();
    return weddingValidator.checkWedding(studentOrder);
  }
  public static AnswerChilren checkChildren(StudentOrder studentOrder) {
    ChildrenValidator childrenValidator = new ChildrenValidator();
    return childrenValidator.checkChildren(studentOrder);
  }
  public static AnswerStudent checkStudent(StudentOrder studentOrder) {
    StudentValidator studentValidator = new StudentValidator();
    return studentValidator.checkStudent(studentOrder);
  }
}
