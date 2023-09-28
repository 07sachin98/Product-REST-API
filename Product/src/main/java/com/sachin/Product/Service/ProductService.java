package com.sachin.Product.Service;

import com.sachin.Product.Entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();

    Product getProduct(Long id);

    ResponseEntity<HttpStatus> addProduct(Product product);

    ResponseEntity<HttpStatus> updateProduct(Product product);

    ResponseEntity<HttpStatus> deleteProduct(Long id);
}
