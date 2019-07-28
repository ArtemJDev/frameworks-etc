package main.java.beans;

import java.sql.Connection;
import java.util.ArrayList;
import main.java.db.Database;

public class AuthorList {

  private ArrayList<Author> authorList = new ArrayList<>();

  public ArrayList<Author> getAuthorList() {
    try {
      Connection connection = Database.getConnection();
    }
    return ;
  }
}
