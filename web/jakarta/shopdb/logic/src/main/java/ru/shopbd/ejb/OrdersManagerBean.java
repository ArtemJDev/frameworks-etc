package main.shopdb.logic.src.main.java.ru.shopbd.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.shopbd.domain.Order;
import ru.shopbd.domain.Thing;
import ru.shopbd.domain.ThingInOrder;

@Stateless
@LocalBean
public class OrdersManagerBean {

  @PersistenceContext(unitName = "examplePU")
  private EntityManager entityManager;

  public Order createOrder(){
    Order order = new Order();
    entityManager.persist(order);

    return order;
  }


  public boolean addToOrder(long thingId,long orderId,int quantity){
    Thing thing = entityManager.find(Thing.class,thingId);
    if(thing == null){
      return false;
    }

    Order order = entityManager.find(Order.class,orderId);
    if(order == null){
      return false;
    }

    ThingInOrder thingInOrder = new ThingInOrder();
    thingInOrder.setThing(thing);
    thingInOrder.setOrder(order);
    thingInOrder.setQuantity(quantity);

    entityManager.persist(thingInOrder);

    return true;
  }

  public List<Thing> getThingsInOrder(long orderId){
    Order order = entityManager.find(Order.class,orderId);
    if(order == null){
      return Collections.emptyList();
    }

    List<ThingInOrder> thingInOrders = order.getThingInOrders();
    List<Thing>result = new ArrayList<>();

    for(ThingInOrder thingInOrder : thingInOrders){
      result.add(thingInOrder.getThing());
    }

    return result;
  }
}

