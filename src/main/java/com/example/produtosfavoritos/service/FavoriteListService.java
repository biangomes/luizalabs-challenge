package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.repository.FavoriteListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteListService {

    @Autowired
    private FavoriteListRepository repo;

    public List<Product> getFavoriteListForAClient(Long id) {
        List<Product> records = repo.findAllFavoritesProducts(id);
        return records;
    }
}
