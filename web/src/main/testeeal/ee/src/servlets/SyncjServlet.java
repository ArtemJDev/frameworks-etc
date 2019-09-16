package main.testeeal.ee.src.servlets;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/synch", asyncSupported = true)
public class SyncjServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
  AsyncContext context =  req.getAsyncContext();
    context.start(new Runnable() {
      @Override
      public void run() {

      }
    });
    context.complete();
  }
}
