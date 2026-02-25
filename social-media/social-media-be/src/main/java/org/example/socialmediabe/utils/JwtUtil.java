package org.example.socialmediabe.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // @Value tells Spring to grab the value from application.properties
    // This allows us to keep our secret key hidden out of the source code
    @Value("${jwt.secret}")
    private String secretKey;

    // The #{...} tells Spring to evaluate the math equation in application.properties
    // Example: 1000 * 60 * 60 * 24 instead of treating it as plain text
    @Value("#{${jwt.expiration}}")
    private long expiration;
    
    private Key getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String verifyToken(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    };

    public String generateToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()
                + expiration))
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    };
}
