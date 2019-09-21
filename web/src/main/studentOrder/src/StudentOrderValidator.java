package main.studentOrder.src;

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
    System.out.println("City Registry Is Running");
    AnswerCityRegister answerCityRegister = new AnswerCityRegister();
    return answerCityRegister;
  }

  static AnswerWedding checkWedding(StudentOrder studentOrder) {
    System.out.println("Wedding Is Running");
    AnswerWedding answerWedding = new AnswerWedding();
    return  answerWedding;
  }
  static AnswerChilren checkChildren(StudentOrder studentOrder) {
    System.out.println("Children check Is Running");
    AnswerChilren answerChilren = new AnswerChilren();
    return  answerChilren;
  }
  static AnswerStudent checkStudent(StudentOrder studentOrder) {
    System.out.println("Student check Is Running");
    AnswerStudent answerStudent = new AnswerStudent();
    return answerStudent;
  }
}
