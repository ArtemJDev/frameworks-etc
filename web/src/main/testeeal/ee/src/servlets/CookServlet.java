package main.testeeal.ee.src.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie")
public class CookServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Cookie[] cookies =  req.getCookies();

    for(Cookie cookie : cookies) {
      System.out.println(cookie.getName());
      System.out.println(cookie.getValue());
    }
    //добавление своих
    Cookie cookieMy = new Cookie("Test_name","test_value");
    cookieMy.setMaxAge(-1); //жизненный цикл куки -1 бесконечность 0 удалить
    cookieMy.setPath("/hello"); //кука тольуо на определенной страницу
    resp.addCookie(cookieMy);

  }
}
