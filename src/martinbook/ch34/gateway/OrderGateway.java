package martinbook.ch34.gateway;

/**
 * Created by max on 15/04/14.
 */
public interface OrderGateway {
    void insert(Order order) throws Exception;
    Order find(int id) throws Exception;
}
