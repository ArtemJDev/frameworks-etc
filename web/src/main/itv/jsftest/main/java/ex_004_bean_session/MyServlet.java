package main.itv.jsftest.main.java.ex_004_bean_session;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Asus on 20.05.2018.
 */
public class MyServlet extends HttpServlet {

    @Inject
    private ExampleBeanSession beanSession;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        writer.write("<html>");
        writer.write("<head>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<p>" + beanSession.getLogin() + "</p>");
        writer.write("<p>" + beanSession.getPassword() + "</p>");
        writer.write("<p>" + beanSession.isLogged() + "</p>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
