package com.example.produtosfavoritos.config;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class ProductWebClient {
    
    WebClient webClient = WebClient.builder()
    .baseUrl("http://challenge-api.luizalabs.com/api/product/")
    .defaultCookie("cookieKey", "cookieValue")
    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
    .defaultUriVariables(Collections.singletonMap("url", "http://challenge-api.luizalabs.com/api/product/"))
    .build();
}
