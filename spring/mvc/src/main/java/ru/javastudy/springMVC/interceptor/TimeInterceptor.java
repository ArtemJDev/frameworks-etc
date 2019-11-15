package mvc.src.main.java.ru.javastudy.springMVC.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeInterceptor extends HandlerInterceptorAdapter {


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    request.setAttribute("startTime", System.currentTimeMillis());

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    Long startTime = Long.valueOf(request.getAttribute("startTime").toString());

    Thread.sleep(2900);

    int totalTime = (int) ((System.currentTimeMillis() - startTime) / 1000) % 60;

    modelAndView.addObject("totalTime:", totalTime);
    System.out.println(" post handle "+ totalTime + " sec");
  }
}
