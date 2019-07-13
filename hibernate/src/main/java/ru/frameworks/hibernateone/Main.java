package ru.frameworks.hibernateone;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import ru.frameworks.hibernateone.entity.Author;
import ru.frameworks.hibernateone.entity.Book;

public class Main {

  private static final Logger log = Logger.getLogger(Book.class);

  public static void main(String[] args) {
//    SessionFactory sessionFactory = org.hibernate.tutorials.HibernateUtil.getSessionfactory();

    log.info("Это информационное сообщение!");

    Session session = HibernateUtil.getSessionfactory().openSession();

    for(Book book : new BookHelper().getBookList()){
      System.out.println("book = " + book.getName());
    }
    log.error("          ");
  }
}
