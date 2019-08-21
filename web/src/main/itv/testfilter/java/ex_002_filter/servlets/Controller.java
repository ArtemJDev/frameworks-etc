package main.itv.testfilter.java.ex_002_filter.servlets;

import ex_002_filter.command.Command;
import ex_002_filter.command.CommandFactory;
import ex_002_filter.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Asus on 16.05.2018.
 */
public class Controller extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
    }

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (request.getSession().getAttribute("users") == null) {
            request.getSession().setAttribute("users", request.getAttribute("users"));
        }

        CommandFactory commandFactory = CommandFactory.commandFactory();
        Command command = commandFactory.getCommand(request);
        String page = command.execute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
