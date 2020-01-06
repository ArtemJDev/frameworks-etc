package ru.executor.simple;

import java.sql.SQLException;
import ru.executor.paternex.ExecutorT;
import ru.executor.logger.DataBaseServiceLog;

/**
 * Get object from Result Set
 */
public class DataBaseServiceSimple extends DataBaseServiceLog {
    private static final String SELECT_USER = "select name from user where id=%s";

    @Override
    public String getUserName(int id) throws SQLException {
        ExecutorT execT = new ExecutorT(getConnection());

        return execT.execQuery(String.format(SELECT_USER, id), result -> {
            result.next();
            return result.getString("name");
        });
    }
}
