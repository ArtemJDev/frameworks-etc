package main.itv.servlets.src.servlets.thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadServlet extends HttpServlet {

  private List<String> operations = new ArrayList<>();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    proccessRequest(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    proccessRequest(req, resp);
  }

  private void proccessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = resp.getWriter();
    try {
      String operation = req.getParameter("op");
      System.out.println(operation);
      double value1 = Double.valueOf(req.getParameter("val1"));
      System.out.println(value1);
      double value2 = Double.valueOf(req.getParameter("val2"));
      System.out.println(value2);
      switch (operation) {
        case "add": operations.add(value1 + " + " + value2 + " = " + (value1+value2));
          break;
        case "sub": operations.add(value1 + " - " + value2 + " = " + (value1-value2));
          break;
        case "mult": operations.add(value1 + " * " + value2 + " = " + (value1*value2));
          break;
        case "div": operations.add(value1 + " / " + value2 + " = " + (value1/value2));
          break;
        default: throw new Exception();
      }
      writer.println("<html>");
      writer.println("<head>");
      writer.println("<title>Arifmetic multithreading</title>");
      writer.println("</head>");
      writer.println("<body>");
      //на разных браузерах разные браузеры, списко операций других пользователей
      //решение не создавать поле на уровне класса - а в конкретном ответе пользователю
      //в методе. Предварительно добавив лист в сессию =(List<String>)req.getSession().getAttribute("List")
      for (String result : operations) {
        writer.print("<p>" + result + "</p>");
      }}  catch (Exception e) {
      writer.println("<p>Ошибка оператора</p>");
//      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
      e.printStackTrace();
    } finally {
      writer.println("</body");
      writer.println("</html>");
      writer.close();
    }
  }
}