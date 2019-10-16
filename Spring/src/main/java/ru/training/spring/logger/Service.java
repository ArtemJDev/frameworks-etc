package ru.training.spring.logger;

import org.springframework.stereotype.Component;

@Component
public class Service {

    public int getIntValue() {
      return 5;
    }

    public double getDoubleValue() {
      return 5.6;
    }

}
