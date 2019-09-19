package main.testeeal.ee.src.CDI;

import java.io.IOException;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/di")
public class DIServlet extends HttpServlet {

  @Inject
  Parent parent;

  @Inject
  Mybean mybean;

  @Inject
  ChangeMyBean changeMyBean;

  @Inject
  Student student;

  @Inject
  BookService bookService;

  @Inject
  BookSubscribe  bookSubscribe;

  @Inject
  A a;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {


  }
}

interface A {
  void print();
}

class B implements A {

  @Override
  public void print() {
    System.out.println("B");
  }
}

@Specializes //инжектиться везде где исп А
class C extends B {
  @Override
  public void print() {
    System.out.println("C");
  }
}

