package main.testeeal.ee.src.controller;

import Bean.Student;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyController")
public class MyController extends HttpServlet {
    MyModelClas myModelClas = new MyModelClas();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Student student = myModelClas.getStudent();
//    req.setAttribute("Student",student);
    req.getSession().setAttribute("Student",student);
//    req.getServletContext().setAttribute("Student", student);
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/test/MyView.jsp");
    requestDispatcher.forward(req,resp);

  }
}
