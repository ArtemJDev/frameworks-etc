package reflection;
@Author(name = "Arten", dateOfCreation = 2019)
public class Person {
  private int id;
  private String name;

  public Person() {
    this.id = -2;
    this.name = "No name";
  }

  public void sayHello() {
    System.out.println("Person with id : " + id + " and name  " + name + " says hello");
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
