package main.testeeal.ee.src.controller;

import Bean.Student;

public class MyModelClas {
  public Student getStudent() {
    Student student = new Student();
    student.setAge(15);
    student.setName("Nike");
    //...
    return student;
  }
}
