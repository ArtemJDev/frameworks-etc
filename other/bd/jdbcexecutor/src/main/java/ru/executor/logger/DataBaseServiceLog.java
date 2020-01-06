package ru.executor.logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import ru.executor.connection.DataBaseServiceUpdate;
import ru.executor.executor.LoggingExecutor;
/**
 * Do logging SELECT from DB
 */
public class DataBaseServiceLog extends DataBaseServiceUpdate {
    private static final String SELECT_USER = "select name from user where id=%s";

    @Override
    public String getUserName(int id) throws SQLException {
        LoggingExecutor exec = new LoggingExecutor(getConnection());
        //with inner class
        exec.execQuery(String.format(SELECT_USER, id), new ResultHandlerInnerGetName());

        //with anonymous class
        exec.execQuery(String.format(SELECT_USER, id),
            new ResultHandler() {
                @Override
                public void handle(ResultSet result) throws SQLException {
                    result.next();
                    System.out.println("Read user: " + result.getString("name"));
                }
            }
        );

        //with lambda
        exec.execQuery(String.format(SELECT_USER, id),
            result -> {
                result.next();
                System.out.println("Read user: " + result.getString("name"));
            });

        return null;
    }

    private static class ResultHandlerInnerGetName implements ResultHandler {
        public void handle(ResultSet result) throws SQLException {
            result.next();
            System.out.println("Read user: " + result.getString("name"));
        }
    }
}
