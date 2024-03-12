package services;

import dao.Product;

import java.util.List;

public interface IProductService {
    public void addProduct(Product product);
    public void deleteProduct(String reference);
    public List<Product> listAll();

}
