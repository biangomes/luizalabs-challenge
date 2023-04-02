package com.example.produtosfavoritos.service;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
        final var clientToSave = Client.builder()
                .name("Peter Parker")
                .email("peter.parker@gmail.com")
                .password("123")
                .build();

        when(clientRepository.save(any(Client.class))).thenReturn(clientToSave);

        final var actualClient = clientService.save(new Client());

        assertThat(actualClient).usingRecursiveComparison().isEqualTo(clientToSave);
        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    void mustUpdateOneClient() {
        final var clientToSave = Client.builder()
                .name("Mary Jane")
                .email("mary.jane@gmail.com")
                .password("@1234")
                .build();

        when(clientRepository.save(any(Client.class))).thenReturn(clientToSave);

        final var actualClient = clientService.save(new Client());
        assertThat(actualClient).usingRecursiveComparison().isEqualTo(clientToSave);
        verify(clientRepository, times(1)).save(any(Client.class));
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
}
