package main.orderapp.view.src.main.java.ru.orderapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import ru.orderapp.domain.Product;
import ru.orderapp.ejb.ProductsManagerBean;
import ru.orderapp.entity.ProductEntity;

@Named
@SessionScoped
public class ProductListBean implements Serializable {
  private Product newProduct = new Product();

  @EJB
  private ProductsManagerBean productsManagerBean;


  public List<Product> getProducts() {
    List<Product> result = new ArrayList<Product>();
    List<ProductEntity> entities = productsManagerBean.readList(0,100);

    for(ProductEntity productEntity : entities) {
      result.add(productEntity.toDto());
    }
    return result;

  }

  public Product getNewProduct() {
    return newProduct;
  }

  public void createNewOrder() {
    ProductEntity productEntity = new ProductEntity();
    productEntity.fromDTO(newProduct);
    productsManagerBean.create(productEntity);
    newProduct = new Product();
  }
}
