package main.shopdb.view.src.main.java.ru.shopbd;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import ru.shopbd.domain.Order;
import ru.shopbd.domain.Thing;
import ru.shopbd.ejb.OrdersManagerBean;
import ru.shopbd.ejb.ThingsManagerBean;

@Named("orderBean")
@SessionScoped
public class OrderBean implements Serializable {

  private Order order;
  private String name;
  private int quantity;

  @EJB
  private OrdersManagerBean ordersManagerBean;

  @EJB
  private ThingsManagerBean thingsManagerBean;

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

  public void createOrder(){
    if(order == null){
      order = ordersManagerBean.createOrder();
    }
  }

  public void createThing(){
    thingsManagerBean.createThing(name,quantity);
  }

  public List<Thing> getThings(){
    return thingsManagerBean.getThings();
  }

  public void addThing(Thing thing){
    if(order == null){
      return;
    }
    ordersManagerBean.addToOrder(thing.getId(),order.getId(),1);
  }

  public List<Thing> getThingsInOrder(){
    if(order == null){
      return Collections.emptyList();
    }

    return ordersManagerBean.getThingsInOrder(order.getId());
  }
}