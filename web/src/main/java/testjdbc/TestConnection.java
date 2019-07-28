package main.java.testjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TestConnection {

  public void check(){
    try {
      InitialContext ic = new InitialContext();
      DataSource ds = (DataSource) ic.lookup("jdbc/Library");
      Connection connection = ds.getConnection();
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("select * from book");
      while(rs.next()) {
        System.out.println(rs.getString("name"));
        System.out.println("1");
      }
    } catch (NamingException e) {
      System.out.println("1");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("2");
      e.printStackTrace();
    }

  }

}
