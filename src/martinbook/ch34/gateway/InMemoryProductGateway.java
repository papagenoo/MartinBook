package martinbook.ch34.gateway;

import java.util.Hashtable;

/**
 * Created by max on 15/04/14.
 */
public class InMemoryProductGateway implements ProductGateway {
    private Hashtable<String, Product> products = new Hashtable<String, Product>();

    @Override
    public void insert(Product product) throws Exception {
        products.put(product.getSku(), product);
    }

    @Override
    public Product find(String sku) throws Exception {
        return (Product)products.get(sku);
    }
}
