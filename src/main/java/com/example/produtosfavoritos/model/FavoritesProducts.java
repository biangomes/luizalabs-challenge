package com.example.produtosfavoritos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="favorites_products")
public class FavoritesProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name="id", referencedColumnName="id")
    private Client client;

    @OneToOne
    @JoinColumn(name="id", referencedColumnName="id")
    private Product product;

}
