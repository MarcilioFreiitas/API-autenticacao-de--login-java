package com.api.login.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.login.data.DetailUserData;
import com.api.login.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticateFilter extends UsernamePasswordAuthenticationFilter{
    
    private final AuthenticationManager authenticationManager;

    public static final int TOKEN_EXPIRE = 600_000;

    public static final String TOKEN_SENHA = "65a28604-7e08-4f90-86ae-a4f98fbebaf5";

    public JWTAuthenticateFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws AuthenticationException {

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
            ));
        } catch (IOException e) {
            throw new RuntimeException("Failure to authenticate user", e);
        }

    }

    @Override
    protected void successfulAuthentication(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain,
        Authentication authResult
    ) throws IOException, ServletException {
                
        DetailUserData userData = (DetailUserData) authResult.getPrincipal();

        String token = JWT.create()
            .withSubject(userData.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRE))
            .sign(Algorithm.HMAC512(TOKEN_SENHA));

        response.getWriter().write(token);
        response.getWriter().flush();

    }
}
