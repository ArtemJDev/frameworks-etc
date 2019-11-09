package mvc.src.main.java.ru.javastudy.springMVC.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//перехват если не обработается в контроллере
@ControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException")
  @ExceptionHandler(RuntimeException.class)
  public void handleRunTime() {
    System.out.println("AOP перехват");
  }
}
