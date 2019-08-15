package main.itv.servlets.src.servlets.servletSecond;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
   resp.setContentType("text/html;charset=UTF-8");

    PrintWriter writer = resp.getWriter();
    try {
      writer.println("<html>");
      writer.println("<head>");
      writer.println("<title> Second Servlet </title>");
      writer.println("</head>");
      writer.println("<body>");
      writer.println("<h1>");
      writer.println("Second Servlet form: " + req.getContextPath());
      writer.println("Привет: " + req.getContextPath());
      writer.println("</h1>");
      writer.println("</body>");
      writer.println("</html>");
    } finally {
      writer.close();
    }
  }
}
