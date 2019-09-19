package main.testeeal.ee.src.CDI;

import CDI.Book.Add;
import CDI.Book.Delete;
import javax.enterprise.event.Event;
import javax.inject.Inject;

public class BookService {
  @Inject
  @Add
  Event<Book> addEvent;
  @Inject
  @Delete
  Event<Book> deleteEvent;
  public void addBook(Book book) {
    System.out.println(book.getName() + "book was added");
    addEvent.fire(book);
  }
  public void deleteBook(Book book) {
    System.out.println(book.getName() + "book was deleted");
    deleteEvent.fire(book);
  }
}
