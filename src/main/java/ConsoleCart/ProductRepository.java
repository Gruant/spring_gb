package ConsoleCart;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class ProductRepository {

    private final List<Product> products = new LinkedList<>();

    @PostConstruct
    private void createProducts(){
        for (int i = 0; i < 5; i++) {
            products.add(new Product(i+1, "product number " + (i+1), String.valueOf((int) (Math.random() * 1000))));
        }
    }

    public void showAllProducts(){
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product ShowById(int id){
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;

    }




}
