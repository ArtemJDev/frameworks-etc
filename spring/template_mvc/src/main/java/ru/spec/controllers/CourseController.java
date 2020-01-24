package template_mvc.src.main.java.ru.spec.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.spec.DAO.dbspringdata.Course;
import ru.spec.DAO.dbspringdata.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    //get vies with lists all courses
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "courses/list";
    }

}
