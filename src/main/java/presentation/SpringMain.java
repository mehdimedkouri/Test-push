package presentation;

import config.AppConfig;
import dao.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
            Product product = context.getBean(Product.class);
            product.setDescription("marshmellow");
            System.out.println(product);
        }
    }
}
