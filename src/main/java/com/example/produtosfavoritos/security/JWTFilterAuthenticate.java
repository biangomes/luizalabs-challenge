package com.example.produtosfavoritos.security;

import com.auth0.jwt.JWT;
import com.example.produtosfavoritos.config.UserProfile;
import com.example.produtosfavoritos.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTFilterAuthenticate extends UsernamePasswordAuthenticationFilter {

    // Token expires at
    public static final int TOKEN_EXPIRES = 600_000;

    public static final String TOKEN_PASSWD = "";

    private final AuthenticationManager authenticationManager;

    public JWTFilterAuthenticate(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            Client client = new ObjectMapper().readValue(request.getInputStream(), Client.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    client.getEmail(),
                    client.getPassword(),
                    new ArrayList<>()
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserProfile userProfile = (UserProfile) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(userProfile.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRES))
                .
    }
}
