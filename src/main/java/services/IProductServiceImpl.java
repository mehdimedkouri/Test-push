package services;

import dao.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component ("customName")
public class IProductServiceImpl implements IProductService {
    List<Product> products ;
    public IProductServiceImpl() {
        products = new ArrayList<Product>();
    }
    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public void deleteProduct(String reference) {
        int i = products
                .stream()
                .filter(product -> product.getReferecne().equals(reference))
                .map(products::indexOf)
                .findFirst()
                .orElse(-1);
        if(i != -1)
            products.remove(i);
        else
            System.out.println("erreur!");
    }

    @Override
    public List<Product> listAll() {
        System.out.println("1");
        return this.products;

    }

    public void afficher(){
        System.out.println("Class 1");
    }
}
