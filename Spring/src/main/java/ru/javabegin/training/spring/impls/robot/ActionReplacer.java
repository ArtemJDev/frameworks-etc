package ru.javabegin.training.spring.impls.robot;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class ActionReplacer implements MethodReplacer {

  @Override
  public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
    System.out.println("FORM INPUT");
    return null;
  }
}
