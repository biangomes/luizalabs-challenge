package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.repository.ClientRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ProductServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;
}
