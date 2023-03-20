package com.example.produtosfavoritos.repository;

import com.example.produtosfavoritos.model.FavoritesProducts;
import com.example.produtosfavoritos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteListRepository extends JpaRepository<FavoritesProducts, Long> {

    @Query("SELECT fp FROM FavoritesProducts fp WHERE fp.client = :client_id")
    List<Product> findAllFavoritesProducts(Long client_id);
}
