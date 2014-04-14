package martinbook.ch34.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 14.04.14
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public interface Order {
    String getCustomerId() throws Exception;
    void addItem(Product p, int quantity) throws Exception;
    int getTotal() throws Exception;
}
