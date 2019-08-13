package main.xmlpack.DOM_object_01.entity;

public class Book {
  private String id;
  private Long Isdn;
  private String title;
  private String author;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getIsdn() {
    return Isdn;
  }

  public void setIsdn(Long isbn) {
    this.Isdn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
