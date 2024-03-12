package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Product {
    private String referecne;
    private String description;
    private double price;
    private int quantity;

    public Product(String description, double price, int quantity){
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
        this.referecne = "AB123";
    }
}
