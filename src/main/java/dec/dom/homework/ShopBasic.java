package dec.dom.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
@Profile("start")
public class ShopBasic {
    private List<Product> basket;

    @Autowired
    public ShopBasic(ProductFactory productFactory) {
        this.basket = productFactory.getProducts();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void displayBasket() {
        for (Product product : basket) {
            System.out.println(product);
        }

        System.out.println("Total value of products is: " + getTotal().doubleValue());
    }

    private BigDecimal getTotal() {
        double total = 0;

        for (Product product : basket) {
            total += product.getPrice().doubleValue();
        }
        return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
    }
}
