package main.itv.testfilter.java.ex_001_filter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean status = (Boolean) request.getAttribute("status");

        request.setAttribute("aaa", status);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ex_001_status.jsp");
        dispatcher.forward(request, response);

    }

}
