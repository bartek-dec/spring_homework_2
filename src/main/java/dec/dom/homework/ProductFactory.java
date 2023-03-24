package dec.dom.homework;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductFactory {

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Klapki"));
        products.add(new Product("Spodenki"));
        products.add(new Product("T-shirt"));
        products.add(new Product("Ręcznik"));
        products.add(new Product("Okulary"));
        return products;
    }
}
