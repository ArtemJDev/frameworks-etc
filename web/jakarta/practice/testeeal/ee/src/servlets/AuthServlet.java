package main.testeeal.ee.src.servlets;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/authservlet")
public class AuthServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
     if( req.isUserInRole("Administrator")) {
       resp.getWriter().write("Okkkey");
       System.out.println(req.getRemoteUser());

       Principal principal = req.getUserPrincipal(); //обертка над юзером

     }
  }
}
