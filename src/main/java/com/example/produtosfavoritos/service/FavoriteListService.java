package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.repository.FavoriteListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteListService {

    @Autowired
    private FavoriteListRepository repo;


}
