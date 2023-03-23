package com.example.produtosfavoritos.repository;

import com.example.produtosfavoritos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.email LIKE '%:email%'")
    Optional<Client> findByEmail(String email);
}
