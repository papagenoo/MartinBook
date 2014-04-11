package martinbook.ch34.proxy;

/**
 * Created by max on 11/04/14.
 */
public class ProductDBProxy implements Product {

    private String sku;

    public ProductDBProxy(String sku) {
        this.sku = sku;
    }

    @Override
    public int getPrice() {

        return 0;
    }

}
