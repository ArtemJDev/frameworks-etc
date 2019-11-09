import entitys.Address;
import entitys.Student;
import enums.Days;
import org.hibernate.Session;

public class helloWorld {

  public static void main(String[] args) {


    Session session = HibernateUtil.getSessionfactory().openSession();
    session.beginTransaction();
    Student max = new Student("Den", Days.MONDAT);
    max.setAddress(new Address("Lenina",22));
    session.save(max);
//    session.save(new entitys.Student("Max", Days.MONDAT, new Date()));
    session.flush();
    session.clear();


//  Student get = (Student) session.load(Student.class,37);
//    System.out.println(get.getIdPlusAge());
//    System.out.println(get.getAddress().getStreet());

    session.getTransaction().commit();
  }
}
