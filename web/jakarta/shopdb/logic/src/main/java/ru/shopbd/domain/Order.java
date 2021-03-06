package main.shopdb.logic.src.main.java.ru.shopbd.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zakaz")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToMany(mappedBy = "order") //В одном Заказазе может быть множество Вещей
  private List<ThingInOrder>thingInOrders;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<ThingInOrder> getThingInOrders() {
    return thingInOrders;
  }

  public void setThingInOrders(List<ThingInOrder> thingInOrders) {
    this.thingInOrders = thingInOrders;
  }
}