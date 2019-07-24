package main.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "ServletTest", urlPatterns = {"/ServletTest"})
public class ServletTest extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>"
          + "<head>"
          + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">"
          + "<title>Документ</title>"
          + "<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">"
          + "</head>"
          + "<body>"
          + "<div class=\"main\">"
          + "<div class=\"abzac\">Секретный документ</div>"
          + "<div class=\"content\">"
          + "<div class=\"small_column\">"
          + "<img src=\"images/ibm.jpg\" >"
          + "</div>"
          + "<div class=\"big_column\">"
          + "<div \">"
          + "<table>"
          + "<tr>"
          + " <th>Имя</th>"
          + "  <th>Телефон</th>"
          + "</tr>"
          + "<tr>"
          + "   <td>Петр</td>"
          + "  <td>555444</td>"
          + " </tr>"
          + " <tr>"
          + "  <td>Иван</td>"
          + " <td>111222</td>"
          + " </tr>"
          + "    </table>"
          + "</div>"
          + "<div>"
          + "<ul>"
          + "  <li>Текстовый документ 1</li>"
          + " <li>Текстовый документ 1</li>"
          + "  <li>Текстовый документ 1</li>"
          + "</ul>  "
          + "</div>"
          + "</div>"
          + "</div>"
          + "<div class=\"footer\">Тестовый проект 2013 г</div>"
          + "</div>"
          + "</body>"
          + "</html>");
    } finally {
      out.close();
    }
  }
}
