package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    WebClient webClient = WebClient.create();

    @Autowired
    private ProductRepository repo;

    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://challenge-api.luizalabs.com/api/product/?page=2").build();
    }

    public List<Product> getProducts() {
        WebClient.RequestHeadersSpec<?> request = webClient.get().uri("http://challenge-api.luizalabs.com/api/product/?page=2");
        Flux<Product> productFlux = request.retrieve().bodyToFlux(Product.class);
        Mono<List<Product>> productListToMono = productFlux.collectList();
        List<Product> productList = productListToMono.block();
        return productList;
    }
}
