package com.microservices.ApiGateway.utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    private static final String secretKey = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public boolean validateToken(final String token) {
        try {
            Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token);
            System.out.println("Token is valid.");
            return true;
        } catch (JwtException e) {
            System.out.println("Invalid or tampered token: " + e.getMessage());
            throw e;
        }
    }
}
