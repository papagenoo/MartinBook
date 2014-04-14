package martinbook.ch34.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 14.04.14
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class OrderData {
    public int orderId;
    public String customerId;

    public OrderData() {}

    public OrderData(int orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }
}
