package martinbook.ch34.gateway;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 14.04.14
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public class Order {

    private String cusid;
    private ArrayList<Item> items = new ArrayList<Item>();
    private int id;

    public Order(String cusid) {
        this.cusid = cusid;
    }

    public String getCustomerId() {
        return cusid;
    }

    public void addItem(Product p, int qty) {
        Item item = new Item(p, qty);
        items.add(item);
    }

    public int getTotal() throws Exception {
        int total = 0;
        for (Item item : items) {
            Product p = item.getProduct();
            int qty = item.getQuantity();
            total += p.getPrice() * qty;
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemCount() {
        return items.size();
    }

    public int quantityOf(Product product) {
        for (Item item : items) {
            Product itemProduct = item.getProduct();
            String itemSku = itemProduct.getSku();
            if (itemSku.equals(product.getSku()))
                return item.getQuantity();
        }
        return 0;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
