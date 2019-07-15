package ru.frameworks.hibernateone;

import java.util.List;
import java.util.Queue;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.frameworks.hibernateone.entity.Author;
import ru.frameworks.hibernateone.entity.Book;

public class BookHelper {

  private SessionFactory sessionFactory;

  public BookHelper(){
    sessionFactory = HibernateUtil.getSessionfactory();
  }

  public List<Book> getBookList(){
    //открываем сессию для манипуляции с перс объектами
    Session session = sessionFactory.openSession();

    //Подготовка запроса
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery cq = cb.createQuery(Book.class);
    Root<Book> root = cq.from(Book.class);
    cq.select(root);
    //выполнение запроса
    Query query = session.createQuery(cq);
    List<Book> bookList = query.getResultList();
    session.close();
    return  bookList;


  }


}
