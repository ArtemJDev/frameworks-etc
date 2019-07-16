package ru.frameworks.hibernateone;

import org.apache.log4j.Logger;
import org.h2.util.New;
import org.hibernate.Session;
import ru.frameworks.hibernateone.entity.Author;
import ru.frameworks.hibernateone.entity.Book;

public class Main {


  public static void main(String[] args) {
    //Author author = new Author("тест");
    new AuthorHelper().setAuthor();

    //new AuthorHelper().getAuthor(1l);

//    Session session = HibernateUtil.getSessionfactory().openSession();
//    session.beginTransaction();
//    for (int i = 0; i < 10; i++) {
//      Author a = new Author("name " + i);
//      a.setSecondName("Second name " + i);
//      if(i%10==0){
//        session.flush();
//      }
//      session.save(a);
//    }
//    session.getTransaction().commit();
//    session.close();
//    for (Book book : new BookHelper().getBookList()) {
//      System.out.println("book = " + book.getName());
//    }

  }
}
