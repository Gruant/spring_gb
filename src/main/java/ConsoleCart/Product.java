package ConsoleCart;

public class Product {

    private final int id;
    private final String name;
    private final String price;

    public Product(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product:\n" +
                "id = " + id + "\n" +
                "name = " + name + '\n' +
                "price = " + price + '\n';
    }
}
