package com.example.produtosfavoritos.repository;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.model.FavoritesProducts;
import com.example.produtosfavoritos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteListRepository extends JpaRepository<FavoritesProducts, Long> {

    @Query("SELECT fp FROM FavoritesProducts fp WHERE fp.client = :client_id")
    List<Product> findAllByClient(Long client_id);

    @Query("SELECT fp FROM FavoritesProducts fp WHERE fp.products = :product_id")
    List<Client> findAllByProductId(Long product_id);
}
