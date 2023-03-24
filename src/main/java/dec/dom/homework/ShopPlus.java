package dec.dom.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
@Profile("plus")
public class ShopPlus {
    @Value("${VAT}")
    private double VAT;
    private List<Product> basket;

    @Autowired
    public ShopPlus(ProductFactory productFactory) {
        this.basket = productFactory.getProducts();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void displayBasket() {
        for (Product product : basket) {
            System.out.println(product);
        }

        System.out.println("Total value of products is: " + getTotal().doubleValue());
        System.out.println("Value of VAT tax is: " + getTax().doubleValue());
        System.out.println("Total value, including tax is: " + getTotal().add(getTax()).doubleValue());
    }

    private BigDecimal getTotal() {
        double total = 0;

        for (Product product : basket) {
            total += product.getPrice().doubleValue();
        }
        return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getTax() {
        return getTotal().multiply(new BigDecimal(VAT)).setScale(2, RoundingMode.HALF_UP);
    }
}
