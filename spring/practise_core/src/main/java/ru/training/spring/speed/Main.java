package ru.training.spring.speed;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
    FileManager  fileUtil = (FileManager) context.getBean("fileManager");
    fileUtil.getExtensionCount("c:\\Windows\\System32");
    fileUtil.getExtensiionList("c:\\Windows");
  }
}
