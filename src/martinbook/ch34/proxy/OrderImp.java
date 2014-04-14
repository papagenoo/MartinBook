package martinbook.ch34.proxy;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class OrderImp implements Order {

    private String cusid;
    private ArrayList<Item> items = new ArrayList<Item>();

    public OrderImp(String cusid) {
        this.cusid = cusid;
    }

    @Override
    public String getCustomerId() {
        return cusid;
    }

    @Override
    public void addItem(Product p, int qty) {
        Item item = new Item(p, qty);
        items.add(item);
    }

    @Override
    public int getTotal() throws Exception {
        int total = 0;
        for (Item item : items) {
            Product p = item.getProduct();
            int qty = item.getQuantity();
            total += p.getPrice() * qty;
        }
        return total;
    }
}
