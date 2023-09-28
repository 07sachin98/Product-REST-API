package com.sachin.Product.Controller;


import com.sachin.Product.Entity.Product;
import com.sachin.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/home")
    public String helloWorld()
    {
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id)
    {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public ResponseEntity<HttpStatus> addProduct(@Valid @RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @PutMapping("/products/")
    public ResponseEntity<HttpStatus> updateProduct(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id)
    {
        try
        {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
