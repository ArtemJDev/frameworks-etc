package main.testeeal.ee.src;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

  @Override
  public void init() throws ServletException { //запускается при инициализации
    System.out.println("Initialization");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("doGet");

    String s = "<html>"
        + "<head>"
        + "<title>HelloFrom</title>"
        + "</head>"
        + "<body>"
        + "<h1>HEELO<h1/>"
        + "</body>"
        + "</html>";
    resp.getWriter().write(s);
  }


/**При отправлении запроса (request) пользователя к  Servlet,
 * Servlet вызывает метод  service() чтобы обработать запрос пользователя
 **/
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("Service");

    HttpServletRequest request = null;
    HttpServletResponse response = null;

    try{
      request =(HttpServletRequest) req;
      response = (HttpServletResponse) res;
    }catch (Exception e) {
      e.printStackTrace();
    }
    this.service(request,response);
  }

  @Override
  public void destroy() {  //запускается в конце сервлета
    System.out.println("Destroy");

  }
}
