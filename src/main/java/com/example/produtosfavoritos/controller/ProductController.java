package com.example.produtosfavoritos.controller;

import com.example.produtosfavoritos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService service;


}
