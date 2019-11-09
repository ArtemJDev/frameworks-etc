package main.orderapp.logic.src.main.java.ru.orderapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import ru.orderapp.domain.Product;

@Entity
public class ProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private long price;

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

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }
  //формирование DTO entity из hibernate entity
  public Product toDto() {
    Product product = new Product();
    product.setId(this.id);
    product.setPrice(this.price);
    product.setName(this.name);

    return product;
  }

//формирование hiber entity из DTO entity
  public void fromDTO(Product product) {
    this.setId(product.getId());
    this.setName(product.getName());
    this.setPrice(product.getPrice());
  }
}
