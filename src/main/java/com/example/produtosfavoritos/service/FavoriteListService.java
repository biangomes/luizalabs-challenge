package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.model.FavoritesProducts;
import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.repository.FavoriteListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteListService {

    @Autowired
    private FavoriteListRepository repo;

    public List<Product> getFavoriteListForAClient(Long client_id) {
        List<Product> records = repo.findAllByClient(client_id);
        return records;
    }

    public List<Client> getAllClientWhichFavoriteProductIs(Long product_id) {
        List<Client> records = repo.findAllByProductId(product_id);
        return records;
    }

    public FavoritesProducts save(Client client, List<Product> products) {
        FavoritesProducts favoritesProducts = new FavoritesProducts();

        favoritesProducts.setClient(client);

    }
}
