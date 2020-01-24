package template_mvc.src.main.java.ru.spec.DAO.dbspringdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import template_data.src.main.java.ru.spec.dbspringdata.SpringJpaCourseService;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext");

        CourseService courseDAO = context.getBean("springJpaCourseService", SpringJpaCourseService.class);

//        Course spring = new Course();
//        spring.setTitle("Spring");
//        spring.setLength(40);
//        spring.setDescription("Spring framework and spring MVC");
//
//        courseDAO.insert(spring);

//        courseDAO.delete(9);

////        List<Course> all = courseDAO.findAll();
        for(Course c : courseDAO.findAll()) {
            System.out.println(c);
        }
//        System.out.println(courseDAO.findByTitle("web"));
//        context.close();
    }

}
