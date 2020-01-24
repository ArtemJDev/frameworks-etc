package template_data.src.main.java.ru.spec.dbspringdata;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    List<Course> findAll();
}
