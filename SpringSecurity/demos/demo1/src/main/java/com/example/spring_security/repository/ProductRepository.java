package com.example.spring_security.repository;

import com.example.spring_security.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByIdIs(Long id);
}
