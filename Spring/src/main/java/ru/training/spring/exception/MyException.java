package ru.training.spring.exception;

import org.springframework.dao.DataAccessException;

public class MyException extends DataAccessException {

  private static final long serialVersionUID = 5394203711238298583L;

  public MyException(String msg) {
    super(msg);
  }

}
