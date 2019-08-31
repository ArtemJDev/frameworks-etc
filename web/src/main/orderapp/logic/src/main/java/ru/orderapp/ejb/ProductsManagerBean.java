package main.orderapp.logic.src.main.java.ru.orderapp.ejb;

import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;
import ru.orderapp.entity.ProductEntity;

@LocalBean
@Stateless
public class ProductsManagerBean {

  @PersistenceContext(unitName = "examplePU")
  private EntityManager entityManager;

  //CRUD
  public boolean create(ProductEntity productEntity) {
    if (!checkValid(productEntity)) {
      return false;
    }
    //проверяем есть ли в БД наша сущность
    ProductEntity exitingProduct = entityManager.find(ProductEntity.class, productEntity.getId());
    if (exitingProduct != null) {
      return false;
    }
    //создаем
    entityManager.persist(productEntity);
    return true;
  }

  public ProductEntity read(long id) {
    return entityManager.find(ProductEntity.class,id);
  }

  public boolean update(ProductEntity productEntity) {
    if (!checkValid(productEntity)) {
      return false;
    }
    //проверяем есть ли в БД наша сущность,если нет  = false
    ProductEntity exitingProduct = entityManager.find(ProductEntity.class, productEntity.getId());
    if (exitingProduct == null) {
      return false;
    }
    //обновляем
    entityManager.merge(productEntity);
    return true;
  }

  public boolean delete(long id) {
     ProductEntity result = entityManager.find(ProductEntity.class,id);
     if(result!=null) {
       return false;
     }
    entityManager.remove(result);
     return true;

  }

  public List<ProductEntity> readList(int offset, int limit) {
    if(offset<0 || limit <1) {
      return Collections.emptyList();
    }
    TypedQuery<ProductEntity> query = entityManager.createQuery(
        "Select entity FROM ProductEntity entity",ProductEntity.class);
    query.setFirstResult(offset);
    query.setMaxResults(limit);
    return query.getResultList();
  }

  private boolean checkValid(ProductEntity productEntity) {
    return (productEntity != null  &&
        !StringUtils.isEmpty(productEntity.getName())
        && productEntity.getPrice() > 0);
  }


}
