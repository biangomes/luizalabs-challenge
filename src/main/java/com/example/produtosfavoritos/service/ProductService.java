package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.config.ProductWebClient;
import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Collections;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductWebClient webClient;

    @Autowired
    private ProductRepository repo;

    public List<Product> getAll() {
        return webClient.get()
            .uri("http://challenge-api.luizalabs.com/api/product/")
            .retrieve()
            .bodyToFlux(Product.class);
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
