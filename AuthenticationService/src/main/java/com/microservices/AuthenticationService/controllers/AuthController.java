package com.microservices.AuthenticationService.controllers;

import com.microservices.AuthenticationService.entities.UserCredential;
import com.microservices.AuthenticationService.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/createUser")
    public UserCredential createUser(@RequestBody UserCredential user) {
        return authService.createUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredential userCredential) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredential.getUsername(), userCredential.getPassword()));
        if (authenticate.isAuthenticated()) {
            return authService.generateToken(userCredential.getUsername());
        } else {
            throw new RuntimeException("Authentication failed");
        }
    }

    @GetMapping("/validate")
    public boolean validateToken(@RequestParam("token") String token) {
        return authService.validateToken(token);
    }
}
