package mvc.src.main.java.ru.javastudy.springMVC.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value =  HttpStatus.NOT_FOUND, reason = "File not a number")
@SuppressWarnings("serial")
public class CustomException extends Exception {

  public CustomException() {}

  public CustomException( String message) {
    super(message);
  }
}
