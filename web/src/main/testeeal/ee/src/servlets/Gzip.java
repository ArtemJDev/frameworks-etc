package main.testeeal.ee.src.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/gzip")
public class Gzip extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if(req.getHeader("Accept-Encoding").contains("gzip")) {
      PrintWriter writer = new PrintWriter( new GZIPOutputStream(resp.getOutputStream()));
      writer.write("<h1>Hello World</h1>");
    } else {
      resp.getWriter().write("<h1>Without GZIP</h1>");
    }
  }
}
