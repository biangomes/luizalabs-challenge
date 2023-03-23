package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAll() {
        List<Product> records = repo.findAll();
        return records;
    }

    public Product getById(Long id) {
        Product record = repo.findById(id).orElse(null);
        return record;
    }

    public Product save(Product product) {
        Product record = repo.save(product);
        return record;
    }

}
