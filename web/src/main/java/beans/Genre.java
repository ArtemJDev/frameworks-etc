package main.java.beans;

public class Genre {

  public Genre() {
  }

  private String name;

  public Genre(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}