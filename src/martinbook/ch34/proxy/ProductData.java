package martinbook.ch34.proxy;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by max on 11/04/14.
 */
public class ProductData {
    public String name;
    public int price;
    public String sku;

    public ProductData(String name,
                       int price, String sku)
    {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public ProductData() {}

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof ProductData))
            return false;

        ProductData pd = (ProductData) obj;
        return new EqualsBuilder().
                // if deriving: appendSuper(super.equals(obj)).
                append(name, pd.name).
                append(price, pd.price).
                append(sku, pd.sku).
                isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                // if deriving: appendSuper(super.hashCode()).
                append(name).
                append(sku).
                append(price).
                toHashCode();
    }

}
