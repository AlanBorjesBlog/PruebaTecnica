package com.example.productinventory.service;

import com.example.productinventory.dao.ProductDAO;
import com.example.productinventory.model.Product;
import javax.inject.Inject;
import java.util.List;

public class ProductService {

    @Inject
    private ProductDAO productDAO;

    public void createProduct(Product product) {
        productDAO.create(product);
    }

    public Product updateProduct(Product product) {
        return productDAO.update(product);
    }

    public void deleteProduct(Long id) {
        productDAO.delete(id);
    }

    public Product getProduct(Long id) {
        return productDAO.find(id);
    }

    public List<Product> getAllProducts(int start, int maxResults) {
        return productDAO.findAll(start, maxResults);
    }

    public List<Product> getProductsByName(String name) {
        return productDAO.findByName(name);
    }

    public List<Product> getProductsByCategory(String category) {
        return productDAO.findByCategory(category);
    }
}
