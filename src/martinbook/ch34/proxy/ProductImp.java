package martinbook.ch34.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 14.04.14
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class ProductImp implements Product {
    private int price;
    private String name;
    private String sku;

    public ProductImp(String sku, String name, int price) {
        this.price = price;
        this.name = name;
        this.sku = sku;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSku() {
        return sku;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
