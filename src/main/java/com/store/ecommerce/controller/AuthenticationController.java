package com.store.ecommerce.controller;

import com.store.ecommerce.config.security.TokenService;
import com.store.ecommerce.dto.TokenDto;
import com.store.ecommerce.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody LoginForm form) {
        UsernamePasswordAuthenticationToken dataLogin = form.convert();

        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.generateToken(authentication);
            TokenDto tokenDto = new TokenDto(token, "Bearer");

            return ResponseEntity.ok().body(tokenDto);
        } catch(AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
