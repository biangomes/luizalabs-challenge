package com.example.produtosfavoritos.controller;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService service;


}
