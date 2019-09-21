package main.studentOrder.src;

public class SaveStudentOrder {

  public static void main(String[] args) {
    StudentOrder studentOrder;
    studentOrder = new StudentOrder();
    studentOrder.hFirstName = "Алексей";
    studentOrder.hLastName = "Петров";
    studentOrder.wFirstName = "Галина";
    studentOrder.wLastName = "Петрова";

    long ans = saveStudenOrder(studentOrder);
    System.out.println(ans);
  }

  static long saveStudenOrder(StudentOrder studentOrder) {
    long answer = 199;
    System.out.println("saveStudenOrder");
    return answer;

  }
}
