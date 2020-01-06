package ru.executor.paternex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ru.executor.simple.ResultHandlerT;

public class ExecutorT extends LoggingExecutor {
    private final Connection connection;

    public ExecutorT(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    public <T> T execQuery(String query, ResultHandlerT<T> handler) throws SQLException {
        try(Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            ResultSet result = stmt.getResultSet();
            return handler.handle(result);
        }
    }

}