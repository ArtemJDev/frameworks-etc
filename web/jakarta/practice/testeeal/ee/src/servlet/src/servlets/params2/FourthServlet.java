package main.itv.servlet.src.servlets.params2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FourthServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = resp.getWriter();
    String param2 = req.getParameter("p2");
    Enumeration<String> allParams = req.getParameterNames(); //Enumeration - объект итератор
    try {
      writer.println("<html>");
      writer.println("<head>");
      writer.println("<title> Second Servlet </title>");
      writer.println("</head>");
      writer.println("<body>");
      writer.println("<h1>");
      writer.println("Привет: " + param2);
      int i =1;
      while (allParams.hasMoreElements()) {
        writer.println("<p>");
        String param = allParams.nextElement();
        String value = req.getParameter(param);
        writer.println("param " + i + " " + param + " = " + value);
        writer.println("<p>");
        i++;
      }
      writer.println("</h1>");
      writer.println("</body>");
      writer.println("</html>");
    } finally {
      writer.close();
    }
    //Вывод
//    Привет: Artem
//    param 1 p2 = Artem
//    param 2 ew = 1
//    param 3 rg = екк
  }
}