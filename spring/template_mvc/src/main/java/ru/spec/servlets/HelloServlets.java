package template_mvc.src.main.java.ru.spec.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloServlets() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Server time: " + LocalTime.now()+ "</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
