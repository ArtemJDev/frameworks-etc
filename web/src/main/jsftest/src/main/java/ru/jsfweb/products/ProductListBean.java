package main.jsftest.src.main.java.ru.jsfweb.products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ProductListBean implements Serializable {
  private List<Product> products = new ArrayList<Product>();
  private Product newProduct = new Product();

  @PostConstruct
  private void initialize() {
    Product sugar = new Product();
    sugar.setName("Sugar");
    sugar.setPrice(500);
    sugar.setId(1);
    products.add(sugar);

    Product tea = new Product();
    tea.setName("Tea");
    tea.setPrice(200);
    tea.setId(2);
    products.add(tea);
  }


  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public Product getNewProduct() {
    return newProduct;
  }

  public void createNewOrder() {
    products.add(newProduct);
    newProduct = new Product();
  }
}
