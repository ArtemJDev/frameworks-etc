package main.testeeal.ee.src;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ServletParam extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String one = req.getParameter("one");
    String two = req.getParameter("two");

    System.out.println(one);
    String[] array = req.getParameterValues("one");
    System.out.println(Arrays.toString(array));

    Enumeration<String> paramName = req.getParameterNames();
    while(paramName.hasMoreElements()) {
      System.out.println(paramName.nextElement());
    }

    Map<String, String[]> stringMap = req.getParameterMap();
    System.out.println(req.getRequestURI());
    System.out.println(req.getServletPath());
    System.out.println(req.getLocalPort());
    System.out.println(req.getQueryString()); //строка с параметрами

    String s = "<html>"
        + "<head>"
        + "<title>HelloFrom</title>"
        + "</head>"
        + "<body>"
        + "<h1>Form for Servlet<h1/> "
        + "<form action='param' method='post'> "
        + "<input type='text' name='one'/> "
        + "<input type='text' name='two'/> "
        + "<input type='submit' name='submit'/>"
        + "</form>"
        + "</body>"
        + "</html>";
    resp.getWriter().write(s);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req,resp);
  }
}
