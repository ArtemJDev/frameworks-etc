package template_mvc.src.main.java.ru.spec.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.spec.DAO.dbspringdata.Course;
import ru.spec.DAO.dbspringdata.CourseService;

@Controller
@RequestMapping("/courses/")
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

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") int id, Model model){
        model.addAttribute("course", courseService.findByid(id));
        return "courses/edit";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(Course course, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) { // if error occurred(can add in model)
            model.addAttribute("course", course);
            return "courses/update"; //same page
        }
        courseService.save(course);
        return "redirect:/courses/";
    }

    @RequestMapping(value = "update/0}", method = RequestMethod.GET)
    public String newForm(Model model){
        return "courses/edit";
    }

//    @PreAuthorize("isAuthenticated()")
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, Model model) {
        courseService.delete(id);
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "courses/list";
//        return "redirect:/courses/";
    }

}
