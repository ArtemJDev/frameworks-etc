package main.java.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletError", urlPatterns ={"/ServletError"})
public class ServletError extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.sendError(400);
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }
}
