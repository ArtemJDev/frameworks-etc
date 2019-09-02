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
  private long idForDelete;
  private Product editingProduct;


  @EJB
  private ProductsManagerBean productsManagerBean;

  public List<Product> getProducts() {
    return  productsManagerBean.readList(0,100);
  }

  public Product getNewProduct() {
    return newProduct;
  }

  public void createNewOrder() {

    productsManagerBean.create(newProduct);
    newProduct = new Product();
  }

  public Product getEditingProduct() {
    return editingProduct;
  }

  public void setEditingProduct(Product editingProduct) {
    this.editingProduct = editingProduct;
  }

  //удаляем тот идентификатор, который заполнили
  public  void deleteProduct( ) {
    productsManagerBean.delete(idForDelete);
  }

  public long getIdForDelete() {
    return idForDelete;
  }

  public void setIdForDelete(long idForDelete) {
    this.idForDelete = idForDelete;
  }

  public void saveProduct() {
    productsManagerBean.update(editingProduct);
  }
}
