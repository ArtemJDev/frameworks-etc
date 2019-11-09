package main.testeeal.ee.src.rest.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //для преобразогвания
public class Student {

  String name;

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
