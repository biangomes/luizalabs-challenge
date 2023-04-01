package com.example.produtosfavoritos.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="brand")
    private String brand;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="image")
    private String image;

    @Column(name="review_score")
    private String reviewScore;

}
