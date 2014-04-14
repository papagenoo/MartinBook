package martinbook.ch34.proxy;

/**
 * Created by max on 11/04/14.
 */
public interface Product {
    String getName() throws Exception;
    String getSku() throws Exception;
    int getPrice() throws Exception;
}
