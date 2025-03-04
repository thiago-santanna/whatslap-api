package com.tsswebapps.lapinformatica.whatslap.config;

import com.tsswebapps.lapinformatica.whatslap.domain.model.User;
import com.tsswebapps.lapinformatica.whatslap.domain.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final String SECRET = "mySuperSecretKeyForJwtGeneration12345"; // Chave secreta (32+ caracteres)

    private static UserService userService;

    public JwtUtils(UserService userService) {
        this.userService = userService;
    }

    public static String generateToken(User authentication) {
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

        return Jwts.builder()
                .setSubject(authentication.getUsername())
                .claim("roles", authentication.getTypeUser().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public static User getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();

        return userService.findByUsername(username).orElseThrow(() -> new RuntimeException("usário não encontrado."));
    }
}

