package com.example.produtosfavoritos.config;

import com.example.produtosfavoritos.model.Client;
import com.example.produtosfavoritos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = userRepository.findByEmail(email);

        if (client == null) {
            throw new UsernameNotFoundException("Email has not been found");
        }

        return new UserProfile();
    }
}
