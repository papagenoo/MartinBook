package martinbook.ch34.gateway;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 14.04.14
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class Product {
    private int price;
    private String name;
    private String sku;

    public Product(String name, String sku, int price) {
        this.price = price;
        this.name = name;
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public int getPrice() {
        return price;
    }
}
