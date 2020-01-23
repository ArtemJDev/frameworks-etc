package template.src.main.java.ru.spec.dbspringdata;

import java.util.List;

public  interface CourseService {

    CourseRepository getCourseRepository();
    List<Course> findAll();

}
