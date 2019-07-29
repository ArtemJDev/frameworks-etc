package main.java.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import main.java.db.Database;

public class GenreList {
  private ArrayList<Genre> genreList = new ArrayList<>();
  Statement statement;
  ResultSet resultSet;
  Connection connection;

  public ArrayList<Genre> getGenre() {
    try {
      Connection connection = Database.getConnection();// соединнение с БД
      statement = connection.createStatement();
      resultSet = statement.executeQuery("select * from genre order by name");
      while(resultSet.next()) {
        Genre genre = new Genre();
        genre.setName(resultSet.getString("name"));
        genreList.add(genre);
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
    return genreList;
  }

  public ArrayList<Genre> getGenreList() {
    if(!genreList.isEmpty()) {
      return genreList;
    } else {
      return getGenre();
    }
  }
}
