package ConsoleCart;

import ConsoleCart.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    private static String command;
    private static final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    private static final ProductRepository productRepository = context.getBean(ProductRepository.class);
    private static Cart cart;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cart = context.getBean(Cart.class);
        System.out.println("Привет\nУ нас есть товары, которые можно купить");

        while (true) {
            choice(sc);
            }
    }

    private static void choice(Scanner sc) {
        System.out.println("1 - Добавить товар в корзину");
        System.out.println("2 - Показать все товары");
        System.out.println("3 - Создать новую корзину");
        System.out.println("4 - Показать текущую корзину");
        System.out.println("5 - Удалить товар из корзины");
        String command = sc.next();
        switch (command){
            case "1":
                addToCard(sc);
                break;
            case "2":
                productRepository.showAllProducts();
                break;
            case "3":
                cart = context.getBean(Cart.class);
                System.out.println("Пустая корзина создана\n");
                break;
            case "4":
                cart.showCart();
                break;
            case "5":
                    deleteFromCard(sc);
            default:
                System.out.println("Введена неверная команда\n");

        }

    }

    private static void addToCard(Scanner sc) {
        System.out.println("Введите id товара:\n");
        command = sc.next();
        if (productRepository.ShowById(Integer.parseInt(command)) != null){
            cart.add(Integer.parseInt(command));
        } else {
            System.out.println("Товар с таким ID не найден\n");
        }
    }

    private static void deleteFromCard(Scanner sc) {
        System.out.println("Введите id товара для удаления:\n");
        command = sc.next();
        if (productRepository.ShowById(Integer.parseInt(command)) != null){
            cart.delete(Integer.parseInt(command));
            System.out.println("Товар удален\n");
        } else {
            System.out.println("Товар с таким ID не найден\n");
        }
    }

}
