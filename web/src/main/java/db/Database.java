package main.java.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {

  private static Connection connection;
  private static InitialContext initialContext;
  private static DataSource dataSource;

  public static Connection getConnection(){
    try {
      initialContext = new InitialContext();
      dataSource = (DataSource) initialContext.lookup("jdbc/Library");
      if(connection == null) {
        connection = dataSource.getConnection();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (NamingException e) {
      e.printStackTrace();
    }
    return connection;
  }


}
