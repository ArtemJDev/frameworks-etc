package template.src.test.java.main.java.ru.spec.hibernatedb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class JdbcCourseDAO implements CourseDAO {

    private static final String SQL_SELECT_COURSE = "SELECT id, title, length, description FROM courses";
    private static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " WHERE id = ?";
    private static final String SQL_INSERT_COURSE =
        "INSERT INTO Courses (title,length,description) VALUES (:title, :length, :description)";

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }
}
