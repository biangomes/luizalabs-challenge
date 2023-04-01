package com.example.produtosfavoritos.controller;

import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    WebClient webClient = WebClient.create("http://challenge-api.luizalabs.com/api/product/");

}
