package com.example.produtosfavoritos.controller;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.repository.UserRepository;
import com.example.produtosfavoritos.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<Client>> getAll() {
        List<Client> records = service.getAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        client.setPassword(encoder.encode(client.getPassword()));
        Client record = service.save(client);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    public ResponseEntity<Boolean> checkUser(@RequestParam String email, @RequestParam String password) {

        Client client = userRepository.findByEmail(email);

        if (client.equals(null)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = encoder.matches(password, client.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(valid);
    }
}
