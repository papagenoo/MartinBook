package martinbook.ch34.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class ProductImplementation implements Product {

    private final int price;
    private final String name;

    public ProductImplementation(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
