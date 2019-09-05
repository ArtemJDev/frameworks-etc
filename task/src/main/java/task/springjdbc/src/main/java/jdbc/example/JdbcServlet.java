package task.springjdbc.src.main.java.jdbc.example;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/*")
public class JdbcServlet extends HttpServlet {

  @Inject
  private JdbcBean jdbcBean;

  @Override
  protected void service(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) throws ServletException, IOException {
      jdbcBean.execute();
  }
}
