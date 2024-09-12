package com.example.Second.ProductRepo;

import com.example.Second.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
