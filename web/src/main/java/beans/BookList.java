package main.java.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import main.java.db.Database;

public class BookList {

  private ArrayList<Book> bookList = new ArrayList<>();
  Statement statement;
  ResultSet resultSet;
  Connection connection;

  public ArrayList<Book> getBooks() {
    try {
      Connection connection = Database.getConnection();// соединнение с БД
      statement = connection.createStatement();
      resultSet = statement.executeQuery("select * from book");
      while(resultSet.next()) {
        Book book = new Book();
        book.setName(resultSet.getString("name"));
        book.setGenre(resultSet.getString("genre"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPageCount(resultSet.getInt("page_count"));
        book.setPublishDate(resultSet.getDate("publish_date"));
        book.setPublisher(resultSet.getString("publisher"));
        bookList.add(book);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if(statement!=null)statement.close();
        if(connection!=null) connection.close();
        if(resultSet!=null)resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return bookList;
  }

  public ArrayList<Book> getBookList() {
    if(!bookList.isEmpty()) {
      return  bookList;
    } else {
      return getBooks();
    }
  }
}



