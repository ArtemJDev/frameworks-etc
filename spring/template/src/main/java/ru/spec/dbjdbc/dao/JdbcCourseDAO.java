package template.src.main.java.ru.spec.dbjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

class CourseRowMapper implements RowMapper<Course> {

    public Course mapRow(ResultSet resultSet, int i) throws SQLException {
        Course c = new Course();
        c.setId(resultSet.getInt("id"));
        c.setTitle(resultSet.getString("title"));
        c.setLength(resultSet.getInt("length"));
        c.setDescription(resultSet.getString("description"));

        return c;
    }
}

public class JdbcCourseDAO implements CourseDAO {

    private static final String SQL_SELECT_COURSE = "SELECT id, title, length, description FROM courses";
    private static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " WHERE id = ?";
    private static final String SQL_INSERT_COURSE =
        "INSERT INTO Courses (title,length,description) VALUES (:title, :length, :description)";

    private JdbcTemplate jdbcTemplate;

    public Course findById(int id) {
        return getJdbcTemplate()
            .queryForObject(SQL_SELECT_COURSE_BY_ID, new Object[]{id}, new CourseRowMapper());
    }

    public List<Course> findAll() {
        //auto
        return getJdbcTemplate().query(SQL_SELECT_COURSE, new BeanPropertyRowMapper<>(Course.class));

        //manual map
//        List<Course> courses = new ArrayList<>();
//        List<Map<String, Object>> maps = getJdbcTemplate().queryForList(SQL_SELECT_COURSE);
//        for(Map<String , Object> row : maps) {
//            Course course = new Course();
//            course.setId((int)(row.get("id")));
//            course.setTitle((String)(row.get("title")));
//            course.setLength((int)(row.get("length")));
//            course.setDescription((String)(row.get("description")));
//            courses.add(course);
//        }
//        return courses;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
