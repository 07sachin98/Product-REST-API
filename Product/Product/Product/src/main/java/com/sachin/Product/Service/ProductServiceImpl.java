package com.sachin.Product.Service;

import com.sachin.Product.DAO.ProductDao;
import com.sachin.Product.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getProducts() {
        return productDao.findAll();
    }

    @Override
    public Product getProduct(Long id) {

        return productDao.getById(id);
    }

    @Override
    public ResponseEntity<HttpStatus> addProduct(Product product) {
        try
        {
            productDao.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> updateProduct(Product product) {
        try
        {
            productDao.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteProduct(Long id) {

        try
        {
            Product product = productDao.getById(id);
            productDao.delete(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
