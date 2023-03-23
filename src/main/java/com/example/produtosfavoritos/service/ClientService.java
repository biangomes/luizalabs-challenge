package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public Boolean emailAlreadyExists(String email) {
        Client client = repo.findByEmail(email);
        return client != null;
    }

    public List<Client> getAll() {
        List<Client> records = repo.findAll();
        return records;
    }

    public Client getById(Long id) {
        Client record = repo.findById(id).orElse(null);
        return record;
    }

    public Client save(Client client) {
        if (emailAlreadyExists(client.getEmail())) {
            throw new IllegalArgumentException("This email, " + client.getEmail() + ", already exists. Choose another one");
        }

        Client record = repo.save(client);
        return record;
    }

    public Client update(Client client) {
        Client clientToUpdate = repo.findById(client.getClientId()).orElse(null);
        return repo.save(clientToUpdate);
    }

    public void delete(Long id) {
        Client clientToBeRemoved = repo.findById(id).orElse(null);
        repo.delete(clientToBeRemoved);
    }
}
