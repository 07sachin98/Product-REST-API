package com.sachin.Product.DAO;

import com.sachin.Product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Long> {
}
