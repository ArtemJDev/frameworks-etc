package ru.executor.simple;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultHandlerT<T> {
    T handle(ResultSet resultSet) throws SQLException;

}