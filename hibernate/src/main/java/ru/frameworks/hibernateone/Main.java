package ru.frameworks.hibernateone;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import ru.frameworks.hibernateone.entity.Author;
import ru.frameworks.hibernateone.entity.Book;

public class Main {

  private static final Logger log = Logger.getLogger(Book.class);

  public static void main(String[] args) {
    Author author = new Author("тест");
    //new AuthorHelper().addAuthor(author);
    new AuthorHelper().setAuthor();

    log.info("Начало логирования");
    Session session = HibernateUtil.getSessionfactory().openSession();
    System.out.println(new BookHelper().getBookList().get(0).getName());



//    for (Book book : new BookHelper().getBookList()) {
//      System.out.println("book = " + book.getName());
//    }

  }
}
