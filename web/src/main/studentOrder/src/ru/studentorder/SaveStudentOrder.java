package main.studentOrder.src.ru.studentorder;

import ru.studentorder.domain.Adult;
import ru.studentorder.domain.StudentOrder;

public class SaveStudentOrder {

  public static void main(String[] args) {
    StudentOrder studentOrder = new StudentOrder();


    long ans = saveStudenOrder(studentOrder);
    System.out.println(ans);
  }

  static long saveStudenOrder(StudentOrder studentOrder) {
    long answer = 199;
    System.out.println("saveStudenOrder");
    return answer;

  }

  static StudentOrder buildStudentOrder() {
    StudentOrder studentOrder = new StudentOrder();
    Adult husband = new Adult();
    husband.setGivenName("Andrew");
    studentOrder.setHusband(husband);

    return studentOrder;

  }
}
