package main.itv.servlet.src.servlets.servletParam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletThird extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");

    PrintWriter writer = resp.getWriter();
    String param2 = req.getParameter("p2");

    try {
      writer.println("<html>");
      writer.println("<head>");
      writer.println("<title> Second Servlet </title>");
      writer.println("</head>");
      writer.println("<body>");
      writer.println("<h1>");
      writer.println("Second Servlet form: " + req.getContextPath() + "<br>");
      writer.println("Привет: " + param2);
      writer.println("</h1>");
      writer.println("</body>");
      writer.println("</html>");
    } finally {
      writer.close();
    }
  }
}
