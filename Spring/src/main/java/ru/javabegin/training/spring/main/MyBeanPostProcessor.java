package ru.javabegin.training.spring.main;

import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Жизненный цикл объекта,
 * попадают все создаваемые бины
 * Единый фильтр для бинов
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object object, String name) {
    return  object;
  }

  @Override
  public Object postProcessBeforeInitialization(Object object, String name) {
    System.out.println(object + " - postProcessBeforeInitialization() ");
    return object;
  }
}
