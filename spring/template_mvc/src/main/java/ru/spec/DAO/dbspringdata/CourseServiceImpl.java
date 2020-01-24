package template_mvc.src.main.java.ru.spec.DAO.dbspringdata;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//service layer
@Repository
@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findByid(int id) {
        return null;
    }

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
