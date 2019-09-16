package main.testeeal.ee.src.servlets;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess")
public class SessSevlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session =  req.getSession();
    session.setAttribute("add",55);

    Enumeration<String> attrNames = session.getAttributeNames(); //получаем список атрибутов HashMap

    while(attrNames.hasMoreElements()) {
      String attr = attrNames.nextElement();
      System.out.println( attr + " = " + session.getAttribute(attr));
    }
    session.getMaxInactiveInterval();//максимальное время ссессии
  }
}
