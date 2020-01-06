package ru.executor.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Util connection
 */
public class ConnectionHelper {
    static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            String url = "jdbc:mysql://" +       //db type
                "localhost:" +               //host name
                "3306/" +                    //port
                "db_tst?" +              //db name
                "user=artem" +              //login
                "password=artem" +          //password

                "useSSL=false";             //do not use Secure Sockets Layer


            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}