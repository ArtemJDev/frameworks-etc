package template_mvc.src.main.java.ru.spec.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.spec.DAO.dbspringdata.Course;
import ru.spec.DAO.dbspringdata.CourseService;

@Controller
@RequestMapping("api/course")
public class CourseAPIController {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Course> list() {
        return courseService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Course findById(@PathVariable int id) {
        return courseService.findByid(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Course create(@RequestBody Course course) {
        return courseService.save(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Course update(@RequestBody Course course,@PathVariable int id) {
        course.setId(id);
        return courseService.save(course);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }
}
