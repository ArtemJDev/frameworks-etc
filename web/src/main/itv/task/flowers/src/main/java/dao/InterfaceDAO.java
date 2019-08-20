package main.itv.task.flowers.src.main.java.dao;

import java.sql.Connection;
import java.sql.SQLException;


public interface InterfaceDAO {

    Connection getConnection() throws SQLException;

}
