package main.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletSessionF", urlPatterns ={"/ServletSessionF"})
public class ServletSessionF extends HttpServlet {

  private int count;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    Enumeration enumeration = request.getParameterNames();

    count++;
    request.getSession().setAttribute("count", count);
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try{
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ShowImage</title>");
      out.println("</head>");
      out.println("<body>");
      while (enumeration.hasMoreElements()) {
        String param = enumeration.nextElement().toString();
        String param1 = enumeration.nextElement().toString();
        String param3 = enumeration.nextElement().toString();
        out.println("<h1>Pareme:" + request.getParameter(param) +" "+ request.getParameter(param1)+request.getParameter(param3)   +"</h1>");
      }
      out.println("<h1>Count :" + count + "</h1>");
      out.println("<h1>Count :" + request.getSession().getAttribute("count") + "</h1>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  @Override
  public void init(ServletConfig config) throws ServletException { //имеет доступ к начальным параметрам сервлета
    super.init();
    System.out.println(config.getInitParameter("message"));
  }


}
