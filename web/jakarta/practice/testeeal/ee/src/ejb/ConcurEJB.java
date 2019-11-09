package main.testeeal.ee.src.ejb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Concur")
public class ConcurEJB extends HttpServlet {

  @EJB
  ConcurBean concurEJBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.getWriter().write(concurEJBean.incremI());
  }

  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      new Thread() {
        @Override
        public void run() {
          URLConnection urlConnection = null;
          try {
            urlConnection = new URL("http://localhost:8080/Concur").openConnection();
            Scanner scanner = new Scanner(urlConnection.getInputStream());
            while(scanner.hasNext()) {
              System.out.println(scanner.next());
            }
          } catch (MalformedURLException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      };
    }
  }
}
