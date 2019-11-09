package main.testeeal.ee.src.controller;

import Bean.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TempController")
public class TempController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Student student = new Student("Artem", 25);
    req.setAttribute("stud", student);
    List<String> list = new ArrayList<>();
    list.add("one");
    list.add("two");
    req.setAttribute("list", list);


    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/test/Temp.jsp");
    requestDispatcher.forward(req, resp);
  }
}
