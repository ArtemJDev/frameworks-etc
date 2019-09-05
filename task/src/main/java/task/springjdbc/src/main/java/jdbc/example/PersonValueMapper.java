package task.springjdbc.src.main.java.jdbc.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PersonValueMapper implements RowMapper<PersonValue> {

  @Override
  public PersonValue mapRow(ResultSet resultSet, int i) throws SQLException {
    PersonValue personValue = new PersonValue();
    personValue.setName(resultSet.getString("name"));
    personValue.setLastname(resultSet.getString("lastname"));
    personValue.setId(resultSet.getInt("id"));

    return personValue;
  }
}
