import org.hibernate.Session;

public class helloWorld {

  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionfactory().openSession();
    session.beginTransaction();
    session.close();

  }
}
