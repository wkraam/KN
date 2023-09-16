package com.KN.OrderManagementSystem.Service;

import com.KN.OrderManagementSystem.Exceptions.ProductNotFoundException;
import com.KN.OrderManagementSystem.Model.Product;
import com.KN.OrderManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product newProduct){
        return productRepository.save(newProduct);
    }

    public Product updateProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public Product findProductByIds(Long id) throws Throwable {
        return productRepository.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product: "+id+" is not int the database"));
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public void deleteProduct(Product delProduct){
        productRepository.delete(delProduct);
    }

}
