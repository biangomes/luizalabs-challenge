package com.example.produtosfavoritos.controller;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<Client>> getAll() {
        List<Client> records = service.getAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client record = service.save(client);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }
}
