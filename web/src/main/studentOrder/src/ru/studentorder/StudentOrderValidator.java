package main.studentOrder.src.ru.studentorder;


import ru.studentorder.domain.AnswerChilren;
import ru.studentorder.domain.AnswerCityRegister;
import ru.studentorder.domain.AnswerStudent;
import ru.studentorder.domain.AnswerWedding;
import ru.studentorder.domain.StudentOrder;
import ru.studentorder.mail.MailSender;
import ru.studentorder.validator.ChildrenValidator;
import ru.studentorder.validator.CityValidator;
import ru.studentorder.validator.StudentValidator;
import ru.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {

  private CityValidator cityValidator;
  private WeddingValidator weddingValidator;
  private ChildrenValidator childrenValidator;
  private StudentValidator studentValidator;
  private MailSender mailSender;

  public StudentOrderValidator() {
    cityValidator = new CityValidator();
    weddingValidator = new WeddingValidator();
    childrenValidator = new ChildrenValidator();
    studentValidator = new StudentValidator();
    mailSender = new MailSender();
  }

  public static void main(String[] args) {
    StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
    studentOrderValidator.checkAll();
  }

  public void checkAll() {
    StudentOrder[] soArray = readStudentsOrders();
//    for (int i = 0; i < soArray.length; i++) {
//      checkOneOrder(soArray[i]);
//    }
    for(StudentOrder studentOrder : soArray) {
      checkOneOrder(studentOrder);

    }
  }

  public StudentOrder[] readStudentsOrders() {
    StudentOrder[] soArray = new StudentOrder[3];

    for (int i = 0; i < soArray.length; i++) {
      soArray[i] = SaveStudentOrder.buildStudentOrder(i);
    }


    return soArray;
  }

  public void checkOneOrder(StudentOrder studentOrder) {
    AnswerChilren answerChilren = checkChildren(studentOrder);
    AnswerStudent answerStudent = checkStudent(studentOrder);
    AnswerWedding answerWedding = checkWedding(studentOrder);
    sendMail(studentOrder);
  }

  public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
    return cityValidator.checkCityRegister(studentOrder);
  }

  public AnswerWedding checkWedding(StudentOrder studentOrder) {
    return weddingValidator.checkWedding(studentOrder);
  }

  public AnswerChilren checkChildren(StudentOrder studentOrder) {
    return childrenValidator.checkChildren(studentOrder);
  }

  public AnswerStudent checkStudent(StudentOrder studentOrder) {
    return studentValidator.checkStudent(studentOrder);
  }

  public void sendMail(StudentOrder studentOrder) {
    mailSender.sendMail(studentOrder);
  }
}
