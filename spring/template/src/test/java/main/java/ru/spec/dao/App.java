package template.src.test.java.main.java.ru.spec.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext");

        CourseDAO courseDAO = context.getBean("CourseDao", CourseDAO.class);

//        Course spring = new Course();
//        spring.setTitle("Spring");
//        spring.setLength(40);
//        spring.setDescription("Spring framework and spring MVC");
//
//        courseDAO.insert(spring);

        courseDAO.delete(8);

//        List<Course> all = courseDAO.findAll();
        for(Course c : courseDAO.findAll()) {
            System.out.println(c);
        }
//        System.out.println(courseDAO.findById(1));
        context.close();
    }

}
