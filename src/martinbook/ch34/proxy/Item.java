package martinbook.ch34.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
public class Item {

    private Product product;
    private int quantity;

    public Item(Product product, int qty) {
        this.product = product;
        this.quantity = qty;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
