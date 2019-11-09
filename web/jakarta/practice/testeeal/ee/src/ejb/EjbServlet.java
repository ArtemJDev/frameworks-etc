package main.testeeal.ee.src.ejb;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ejbServlet")
public class EjbServlet extends HttpServlet {

  @EJB
  HelloWorldEJB helloWorldEJB;

  @EJB
  ExampleBean exampleBean;

  @EJB
  ChainBean chainBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {


  }
}
