package services2;

import dao.Product;
import services.IProductService;

import java.util.ArrayList;
import java.util.List;

public class IProductServiceImpl2 implements IProductService {
    List<Product> products ;

    public IProductServiceImpl2(){
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
        return this.products;
    }
    public void updateProduct(String reference, Product produit){
            products
                    .stream()
                    .filter(p -> p.getReferecne() == reference)
                    .findFirst()
                    .ifPresent(produitTrouve -> {
                        int index = products.indexOf(produitTrouve);
                        products.set(index, produit);
                    });
    }
}
