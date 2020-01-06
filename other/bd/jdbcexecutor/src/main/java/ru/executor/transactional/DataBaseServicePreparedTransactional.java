package ru.executor.transactional;

import java.sql.SQLException;
import ru.executor.paternex.ExecutorPrepared;
import ru.executor.prepared.DataBaseServicePrepared;

public class DataBaseServicePreparedTransactional extends DataBaseServicePrepared {
    private static final String INSERT_INTO_USER = "insert into user (name) values(?)";

    @Override
    public void addUsers(String... names) throws SQLException {
        try {
            ExecutorPrepared exec = new ExecutorPrepared(getConnection());
            getConnection().setAutoCommit(false);
            exec.execUpdate(INSERT_INTO_USER, statement -> {
                for (String name : names) {
                    statement.setString(1, name);
                    statement.execute();
                }
            });
            getConnection().commit();
        } catch (SQLException e){
            getConnection().rollback();
        } finally {
            getConnection().setAutoCommit(true);
        }
    }
}