package com.example.produtosfavoritos.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="clientId", nullable=false, unique=true)
    private Long clientId;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="email", unique=true, nullable=false)
    private String email;

    @Column(name="password", nullable=false)
    private String password;

    @OneToMany(mappedBy = "client")
    private List<FavoritesProducts> favoritesProducts;

}
