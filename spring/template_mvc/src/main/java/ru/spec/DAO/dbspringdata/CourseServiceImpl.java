package template_mvc.src.main.java.ru.spec.DAO.dbspringdata;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//service layer
@Repository
@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    private CourseRepository  courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return Lists.newArrayList(courseRepository.findAll());
    }


    @Override
    @Transactional(readOnly = true)
    public Course findByid(int id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
