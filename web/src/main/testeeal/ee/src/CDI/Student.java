package main.testeeal.ee.src.CDI;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Student {
  String name = "Max";
  int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

 public Student() {
    System.out.println("Constructor");
  }
//  @PostConstruct
//  public void doJob() {
//    System.out.println("Do job PostConstruct");
//  }
// @AroundInvoke
//  public Object doJob2(InvocationContext context) throws Exception {
//    System.out.println("Do job AroundInvoke");
//    return context.proceed();
//  }
  public void doJob3() {
    System.out.println("Do job 3");
  }
//  @PreDestroy
//  public void doJob4() {
//    System.out.println("Do job PreDestroy");
//  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
