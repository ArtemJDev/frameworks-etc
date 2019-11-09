package main.itv.jsftest.main.java.ex_006_product_list_bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 20.05.2018.
 */

@Named
@SessionScoped
public class ProductListBean implements Serializable {

    private List<Product> products = new ArrayList<Product>();

    @PostConstruct
    private void init() {
       Product p1 = new Product(1, "Food", 100);
       Product p2 = new Product(2, "Clothes", 1000);
       Product p3 = new Product(3, "Water", 10);
       products.add(p1);
       products.add(p2);
       products.add(p3);
    }

    public List<Product> getProducts() {
        return products;
    }


    public void add(Product product) {
        products.add(product);
    }

}
