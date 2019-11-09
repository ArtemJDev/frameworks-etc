package main.xmlpack.SAX_object_1.entity;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
  private String title;
  private List<Ingridient> ingridients;

  public Sandwich() {
    ingridients = new ArrayList<Ingridient>();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void addIngridient(Ingridient ingridient) {
    ingridients.add(ingridient);
  }

  public List<Ingridient> getIngridients() {
    return ingridients;
  }
}
