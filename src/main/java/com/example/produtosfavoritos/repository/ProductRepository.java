package com.example.produtosfavoritos.repository;

import com.example.produtosfavoritos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
