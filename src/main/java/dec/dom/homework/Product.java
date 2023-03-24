package dec.dom.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private int minRange = 50;
    private int maxRange = 300;
    private String name;
    private BigDecimal price;

    public Product(String name) {
        this.name = name;
        this.price = getPrice(minRange, maxRange);
    }

    private BigDecimal getPrice(double min, double max) {
        double price = ((Math.random() * (max - min)) + min);
        return new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price.doubleValue() +
                '}';
    }

    public BigDecimal getPrice() {
        return price;
    }
}
