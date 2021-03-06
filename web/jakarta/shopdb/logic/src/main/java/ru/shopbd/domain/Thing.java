package main.shopdb.logic.src.main.java.ru.shopbd.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Thing {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private int quantity;

  @OneToMany(mappedBy = "thing") //Одна вещь может находиться во многих заказах
  private List<ThingInOrder> thingInOrders;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public List<ThingInOrder> getThingInOrders() {
    return thingInOrders;
  }

  public void setThingInOrders(List<ThingInOrder> thingInOrders) {
    this.thingInOrders = thingInOrders;
  }
}