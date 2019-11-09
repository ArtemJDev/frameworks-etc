package main.shopdb.logic.src.main.java.ru.shopbd.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ru.shopbd.domain.Thing;

@Stateless
@LocalBean
public class ThingsManagerBean {

  @PersistenceContext(unitName = "examplePU")
  private EntityManager entityManager;


  public Thing createThing(String name, int price){
    Thing thing = new Thing();
    thing.setName(name);
    thing.setQuantity(price);
    entityManager.persist(thing);

    return thing;
  }

  public List<Thing> getThings(){
    TypedQuery<Thing> typedQuery = entityManager.createQuery("select c from Thing c",Thing.class);
    return typedQuery.getResultList();
  }


}