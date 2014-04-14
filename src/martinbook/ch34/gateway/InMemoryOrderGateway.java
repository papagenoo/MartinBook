package martinbook.ch34.gateway;

import java.util.Hashtable;

/**
 * Created by max on 15/04/14.
 */
public class InMemoryOrderGateway implements OrderGateway {

    private static int nextId = 1;
    private Hashtable<Integer, Order> orders = new Hashtable<Integer, Order>();

    @Override
    public void insert(Order order) throws Exception {
        orders.put(nextId++, order);
    }

    @Override
    public Order find(int id) throws Exception {
        return orders.get(id);
    }
}
