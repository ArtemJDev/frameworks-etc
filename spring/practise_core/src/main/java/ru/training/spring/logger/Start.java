package ru.training.spring.logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
    Service service = (Service) context.getBean("service");
    double val = service.getDoubleValue();

  }
}
