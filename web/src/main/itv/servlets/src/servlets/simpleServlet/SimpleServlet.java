package main.itv.servlets.src.servlets.simpleServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();

    writer.println("<html>");
    writer.println("<head>");
    writer.println("<title> Hello World </title>");
    writer.println("</head>");
    writer.println("<body>");
    writer.println("<h1>Hello From Servlet</h1>");
    writer.println("</body>");
    writer.println("</html>");

  }
}
