package main.itv.task.flowers.src.main.java.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Asus on 08.02.2018.
 */
public interface InterfaceDAO {

    Connection getConnection() throws SQLException;

}
