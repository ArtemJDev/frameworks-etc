package template_mvc.src.main.java.ru.spec.DAO.dbspringdata;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    Course findByid(int id);
    Course save(Course course);
    void delete(int id);
}
