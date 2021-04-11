package ConsoleCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class Cart {

    @Autowired
    @Qualifier("productRepository")
    private ProductRepository productRepository;
    private final ArrayList<Integer> productsId = new ArrayList<>();

    public void showCart(){
        if (productsId.size() < 1){
            System.out.println("Корзина пуста\n");
        } else {
            for (Integer integer : productsId) {
                System.out.println(productRepository.ShowById(integer));
            }
        }
    }

    public void add(int id){
        productsId.add(id);
    }

    public void delete(int id){
        for (int i = 0; i < productsId.size(); i++) {
            if(productsId.get(i) == id){
                productsId.remove(i);
                break;
            }
        }
    }
}
