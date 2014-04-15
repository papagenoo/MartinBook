package martinbook.ch34.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 14.04.14
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class OrderProxy implements Order {
    private DB db;
    private int orderId;

    public OrderProxy(int orderId) {
        this.orderId = orderId;
        db = DB.getInstance();
    }

    @Override
    public String getCustomerId() throws Exception {
        OrderData od = db.getOrderData(orderId);
        return od.customerId;
    }

    @Override
    public void addItem(Product p, int quantity) throws Exception {
        ItemData id = new ItemData(orderId, quantity, p.getSku());
        db.store(id);
    }

    @Override
    public int getTotal() throws Exception {
        OrderImp imp = new OrderImp(getCustomerId());
        ItemData[] itemDataArray = db.getItemsForOrder(orderId);
        for (ItemData item : itemDataArray)
        imp.addItem(new ProductProxy(item.sku), item.qty);
        return imp.getTotal();
    }

    public int getOrderId() {
        return orderId;
    }
}
