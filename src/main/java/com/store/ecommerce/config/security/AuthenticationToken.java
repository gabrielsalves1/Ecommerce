package com.store.ecommerce.config.security;

import com.store.ecommerce.model.User;
import com.store.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationToken extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository userRepository;

    public AuthenticationToken(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = retrieveToken(request);
        Boolean valid = tokenService.isValid(token);

        if(valid) {
            authenticateClient(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticateClient(String token) {
        Long idUser = tokenService.getIdUser(token);
        User user = userRepository.findById(idUser).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
}
