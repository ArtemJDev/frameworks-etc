package main.studentOrder.src.ru.studentorder;

import ru.studentorder.domain.Adult;
import ru.studentorder.domain.StudentOrder;

public class SaveStudentOrder {

  public static void main(String[] args) {
    buildStudentOrder(10);
    StudentOrder studentOrder = new StudentOrder();

    long ans = saveStudenOrder(studentOrder);
    System.out.println(ans);
  }

  static long saveStudenOrder(StudentOrder studentOrder) {
    long answer = 199;
    System.out.println("saveStudenOrder");
    return answer;

  }

  static StudentOrder buildStudentOrder(long id) {
    StudentOrder studentOrder = new StudentOrder();
    studentOrder.setStudentOrderId(id);
    Adult husband = new Adult("Васильев","Андрей","Петрович",null);
    return studentOrder;

  }

  static void printStudentOrder(StudentOrder studentOrder) {
    System.out.println(studentOrder.getStudentOrderId());
  }
}
