package ru.executor.base;

import java.sql.SQLException;
import java.util.List;

/**
 * Main interface for work with DB
 */
public interface DataBaseService extends AutoCloseable {

    String getMetaData();

    void prepareTables() throws SQLException;

    void addUsers(String... names) throws SQLException;

    String getUserName(int id) throws SQLException;

    List<String> getAllNames() throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void deleteTables() throws SQLException;
}

