package mvc.src.main.java.ru.javastudy.springMVC.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.User;

@Controller
public class LoginController {

  private static final int WEAK_STRENGTH = 1;
  private static final int FEAR_STRENGTH = 5;
  private static final int STRONG_STRENGTH = 7;

  private static final String WEAK_COLOR = "#FF0000";
  private static final String FEAR_COLOR = "#FF9900";
  private static final String STRONG_COLOR = "#0099CC";

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView main() {
    return new ModelAndView("login", "user", new User());
  }

  @RequestMapping(value = "/check-user", method = RequestMethod.POST )
  public ModelAndView checkUser(@ModelAttribute("user") User user) {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("home");

    modelAndView.addObject("user", user);

    return modelAndView;
  }

  @RequestMapping(value = "/checkStrength", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
  public @ResponseBody String checkStrength(@RequestParam String password) {
    String result = "<span style = \"color:%s; font-weight:bold; \">%s</span>";

    if(password.length() >= WEAK_STRENGTH & password.length() < FEAR_STRENGTH) {
      return String.format(result, WEAK_COLOR, "Слабый");
    }else if(password.length() >= FEAR_STRENGTH & password.length() < STRONG_STRENGTH) {
      return String.format(result, FEAR_COLOR, "Средний");
    } else if(password.length() >= STRONG_STRENGTH) {
      return String.format(result, STRONG_COLOR, "Сильный");
    }
    return "";
  }


}
