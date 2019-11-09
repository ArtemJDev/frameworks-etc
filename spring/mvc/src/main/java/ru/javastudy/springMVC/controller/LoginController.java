package mvc.src.main.java.ru.javastudy.springMVC.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.User;

@Controller
public class LoginController {

  @Autowired
  private MessageSource messageSource;

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

  @RequestMapping(value = "/check-user", method = RequestMethod.POST)
  public String checkUser(Locale locale, @ModelAttribute("user") User user,RedirectAttributes redirectAttributes) {
    //flash испогльзуется для механизма перенаправления
    //действуют только на протяжении перенаправления
//      redirectAttributes.addFlashAttribute("redirect", true);
    redirectAttributes.addFlashAttribute("locale", messageSource.getMessage("locale", new String[] {locale.getDisplayName(locale)},locale));
    return "redirect:/home1";
  }

  @RequestMapping(value = "/home1", method = RequestMethod.GET)
  public String goMainPage(HttpServletRequest request) {
    Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
    //проверка на update от пользователя или системы
    if(map != null) {
      System.out.println("redirect!");
    } else {
      System.out.println("Update");
    }
    return "home";
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


  //test errors
  @RequestMapping(value = "/uploadFile" , method = RequestMethod.POST)
  public ModelAndView uploadFile() throws IOException, CustomException {
    System.out.println("test");
    if(true) {
//      throw new IOException("File not found");
//      throw new RuntimeException("RunTime test");
      throw new RuntimeException("Test");
    }
    return new ModelAndView("error");
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "IOException EEEEE")
  @ExceptionHandler(IOException.class)
  public void handleIOException() {
    System.out.println("Перехвачено");
  }

}
