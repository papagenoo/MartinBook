package martinbook.ch34.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 14.04.14
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public class ProductProxy implements Product {

    private String sku;
    private DB db;

    public ProductProxy(String sku) {
        this.sku = sku;
        db = DB.getInstance();
    }

    @Override
    public String getSku() throws Exception {
        return sku;
    }

    @Override
    public String getName() throws Exception {
        ProductData pd = db.getProductData(sku);
        return pd.name;
    }

    @Override
    public int getPrice() throws Exception {
        ProductData pd = db.getProductData(sku);
        return pd.price;
    }
}
