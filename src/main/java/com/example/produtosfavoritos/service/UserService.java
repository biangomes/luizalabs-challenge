package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<Client> getAll() {
        List<Client> records = repo.findAll();
        return records;
    }

    public Client getById(Long id) {
        Client record = repo.findById(id).orElse(null);
        return record;
    }

    public Client save(Client client) {
        return repo.save(client);
    }
}
