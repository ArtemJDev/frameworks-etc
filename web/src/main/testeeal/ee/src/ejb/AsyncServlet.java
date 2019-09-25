package main.testeeal.ee.src.ejb;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/async")
public class AsyncServlet extends HttpServlet {

  @EJB
  AsyncEjb asyncEjb;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    asyncEjb.getName()
    resp.getWriter().write("After Sleep");
  }
}
