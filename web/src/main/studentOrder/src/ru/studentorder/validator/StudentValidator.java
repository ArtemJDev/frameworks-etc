package main.studentOrder.src.ru.studentorder.validator;

import ru.studentorder.domain.AnswerStudent;
import ru.studentorder.domain.StudentOrder;

public class StudentValidator {
  public AnswerStudent checkStudent(StudentOrder studentOrder) {
    System.out.println("Student check Is Running");
    AnswerStudent answerStudent = new AnswerStudent();
    return answerStudent;
  }
}
