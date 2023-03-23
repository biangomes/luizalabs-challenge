package com.example.produtosfavoritos.controller;

import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> records = service.getAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id) {
        Product record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product record = service.save(product);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Product record = service.save(product);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }
}
