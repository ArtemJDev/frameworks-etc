package ru.frameworks.hibernateone;

import org.hibernate.Session;
import ru.frameworks.hibernateone.entity.Author;
import ru.frameworks.hibernateone.entity.Book;

public class Main {

  public static void main(String[] args) {
//    SessionFactory sessionFactory = org.hibernate.tutorials.HibernateUtil.getSessionfactory();
//    System.out.println("SUCCESS");
    Session session = HibernateUtil.getSessionfactory().openSession();
    for(Author author : new AuthorHelper().getAuthorList()){
      System.out.println("author = " + author.getName());
    }
    for(Book book : new BookHelper().getBookList()){
      System.out.println("book = " + book.getName());
    }
  }
}
