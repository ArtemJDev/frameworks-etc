package ru.executor.prepared;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ru.executor.paternex.ExecutorPrepared;
import ru.executor.paternex.ExecutorT;
import ru.executor.simple.DataBaseServiceSimple;

public class DataBaseServicePrepared extends DataBaseServiceSimple {

    private static final String INSERT_INTO_USER = "insert into user (name) values(?)";

    @Override
    public void addUsers(String... names) throws SQLException {
        ExecutorPrepared exec = new ExecutorPrepared(getConnection());
        exec.execUpdate(INSERT_INTO_USER, statement -> {
            for (String name : names) {
                statement.setString(1, name);
                statement.execute();
            }
        });
    }

    @Override
    public List<String> getAllNames() throws SQLException {
        ExecutorT executor = new ExecutorT(getConnection());

        return executor.execQuery("select name from user", result -> {
            List<String> names = new ArrayList<>();

            while (!result.isLast()) {
                result.next();
                names.add(result.getString("name"));
            }
            return names;
        });
    }
}
