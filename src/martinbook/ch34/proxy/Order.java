package martinbook.ch34.proxy;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 20:14
 * To change this template use File | Settings | File Templates.
 */
public class Order {

    private String name;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order(String name) {
        this.name = name;
    }

    public void addItem(Product product, int qty) {
        Item item = new Item(product, qty);
        items.add(item);
    }

    public int getTotal() {
        int total = 0;
        for (Item item : items)
        {
            Product p = item.getProduct();
            int qty = item.getQuantity();
            total += p.getPrice() * qty;
        }
        return total;
    }
}
