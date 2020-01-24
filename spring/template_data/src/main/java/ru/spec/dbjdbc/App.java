package template_data.src.main.java.ru.spec.dbjdbc;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spec.dbjdbc.dao.Course;
import ru.spec.dbjdbc.dao.CourseDAO;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext");

        CourseDAO  courseDAO = context.getBean(CourseDAO.class);
        List<Course> all = courseDAO.findAll();
        for(Course c : all) {
            System.out.println(c);
        }
        context.close();
        }
}
