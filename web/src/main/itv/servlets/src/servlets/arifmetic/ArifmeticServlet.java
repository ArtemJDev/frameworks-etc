package main.itv.servlets.src.servlets.arifmetic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArifmeticServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = resp.getWriter();

    String operation = req.getParameter("operation");
    Double value1 = Double.parseDouble(req.getParameter("var1"));
    Double value2 = Double.parseDouble(req.getParameter("var2"));

    try {
      writer.println("<html>");
      writer.println("<head>");
      writer.println("<title> Second Servlet </title>");
      writer.println("</head>");
      writer.println("<body>");
      writer.println("<p>");

      switch (operation) {
        case "add": writer.print(value1 + " + " + value2 + " = " + (value1+value2));
          break;
        case "sub": writer.print(value1 + " - " + value2 + " = " + (value1-value2));
          break;
        case "mult": writer.print(value1 + " * " + value2 + " = " + (value1*value2));
          break;
        case "div": writer.print(value1 + " / " + value2 + " = " + (value1/value2));
          break;
        default: throw new Exception();
      }
      writer.print("</p1>");
      writer.println("</body>");
      writer.println("</html>");
    } catch (Exception e) {
      writer.println("<p>Ошибка оператора</p>");
//      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
    } finally {
      writer.close();
    }

  }
}