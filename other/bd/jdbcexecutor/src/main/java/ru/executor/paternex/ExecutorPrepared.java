package ru.executor.paternex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecutorPrepared extends LoggingExecutor {

    public ExecutorPrepared(Connection connection) {
        super(connection);
    }

    public void execUpdate(String update, ExecuteHandler prepare) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(update);
            prepare.accept(stmt);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public interface ExecuteHandler {
        void accept(PreparedStatement statement) throws SQLException;
    }
}