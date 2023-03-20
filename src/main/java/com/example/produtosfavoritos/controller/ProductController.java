package com.example.produtosfavoritos.controller;

import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
