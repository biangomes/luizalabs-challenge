package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.model.Product;
import com.example.produtosfavoritos.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    void mustSaveOneClient() {
        final var clientToSave = Client.builder().name("Peter Parker").email("peter.parker@gmail.com").build();
        when(clientRepository.save(any(Client.class))).thenReturn(clientToSave);

        final var actualClient = clientService.save(new Client());

        assertThat(actualClient).usingRecursiveComparison().isEqualTo(clientToSave);
        verify(clientRepository, times(1)).save(any(Client.class));
        verifyNoMoreInteractions(clientRepository);
    }

    @Test
    void checkIfEmailAlreadyExists() {
        String email = "isthisemailnew@gmail.com";
        Client client = new Client();

        client.setEmail(email);
        Mockito.when(clientRepository.findByEmail(email)).thenReturn(Optional.of(client).orElseThrow());

        boolean result = clientService.emailAlreadyExists(email);

        Assertions.assertTrue(result);
    }

    void mustGetAllClients() {
        // Preparing data
        Mockito.when(clientRepository.findAll()).thenReturn(Arrays.asList(
                new Client(1L,
                        "Alex Raider",
                        "alexra1der@hotmail.com",
                        (List<Product>) new Product(1L,
                                "iPhone 12 Pro",
                                "Apple",
                                new BigDecimal(11499.00),
                                "https://www.magazineluiza.com.br/iphone-12-pro-apple-prata-512gb-desbloqueado-mgmv3bz-a/p/dkg489be2f/te/i12p/")),

                new Client(2L,
                        "Angelina Jolie",
                        "jolie@outlook.com",
                        (List<Product>) new Product())));


        // Testing
        List<Client> clients = clientRepository.findAll();
        Assertions.assertEquals(clients.get(0), );
    }
}
