package main.testeeal.ee.src.CDI;

import CDI.Book.Add;
import CDI.Book.Delete;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;

@Singleton
public class BookSubscribe {

  List<Book> list = new ArrayList<>();

  public void addBook(@Observes @Add Book book) {
    System.out.println(book.getName() + " added to list ");
    list.add(book);
  }

  public void delete(@Observes @Delete Book book) {
    System.out.println(book.getName() + " deleting from list ");
    list.remove(book);
  }
}
