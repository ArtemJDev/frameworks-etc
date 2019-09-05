package main.orderapp.logic.src.main.java.ru.orderapp.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;
import ru.orderapp.domain.Product;
import ru.orderapp.entity.ProductEntity;

@LocalBean
@Stateless
public class ProductsManagerBean {
  //гарантированно будет один и тот же entity manager
  @PersistenceContext(unitName = "examplePU")
  private EntityManager entityManager;

  //CRUD
  public boolean create(Product product) {
    if (!checkValid(product)) {
      return false;
    }
    //проверяем есть ли в БД наша сущность
    ProductEntity exitingProduct = entityManager.find(ProductEntity.class, product.getId());
    if (exitingProduct != null) {
      return false;
    }
    exitingProduct = new ProductEntity();
    exitingProduct.fromDTO(product);
    //создаем
    entityManager.persist(exitingProduct);
    return true;
  }

  public Product read(long id) {
    ProductEntity  productEntity = entityManager.find(ProductEntity.class, id);
    if (productEntity == null) {
      return null;
    }
    return productEntity.toDto();
  }

  public boolean update(Product product) {
    if (!checkValid(product)) {
      return false;
    }
    //проверяем есть ли в БД наша сущность,если нет  = false
    ProductEntity exitingProduct = entityManager.find(ProductEntity.class, product.getId());
    if (exitingProduct == null) {
      return false;
    }
    exitingProduct.fromDTO(product);
    //обновляем
    entityManager.merge(exitingProduct);
    return true;
  }

  public boolean delete(long id) {
    ProductEntity result = entityManager.find(ProductEntity.class, id);
    if (result == null) {
      return false;
    }
    entityManager.remove(result);
    return true;

  }

  public List<Product> readList(int offset, int limit) {
    if (offset < 0 || limit < 1) {
      return Collections.emptyList();
    }
    TypedQuery<ProductEntity> query = entityManager.createQuery(
        "Select entity FROM ProductEntity entity", ProductEntity.class);
    query.setFirstResult(offset);
    query.setMaxResults(limit);
    List<ProductEntity> productEntities =  query.getResultList();
    if(productEntities == null || productEntities.isEmpty()) {
      return  Collections.emptyList();
    }
    List<Product> result = new ArrayList<>(productEntities.size());
    for(ProductEntity productEntity : productEntities) {
      result.add(productEntity.toDto());
    }
    return result;
  }

  private boolean checkValid(ProductEntity productEntity) {
    return (productEntity != null &&
        !StringUtils.isEmpty(productEntity.getName())
        && productEntity.getPrice() > 0);
  }

  private boolean checkValid(Product product) {
    return (product != null &&
        !StringUtils.isEmpty(product.getName())
        && product.getPrice() > 0);
  }
}
