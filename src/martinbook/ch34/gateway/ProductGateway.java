package martinbook.ch34.gateway;

/**
 * Created by max on 15/04/14.
 */
public interface ProductGateway {
    void insert(Product product) throws Exception;
    Product find(String sku) throws Exception;
}
