package com.example.spring_security.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component // faire référence au contexte Spring, pour que Spring puiss ele gérer et que jepuiss ela manipuler plus facilement
public class JwTProvider {

    @Value("{jwt.secret}")
    private String secret;

    private SecretKey getSignInKey(){

        byte[] keyBytes = Base64.getDecoder().decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);

    }

    public String generateToken(Authentication auth){
        String username = auth.getName(); // initialiser username
        Date currentDate = new Date();
        Date expireDate = new Date (currentDate.getTime() + 86400000); // -> 24h en millisecondes // durée de vie du token

        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(expireDate)
                .setIssuedAt(new Date())
                .signWith(getSignInKey(), SignatureAlgorithm.HS512)
                .compact();

        return token;
    }


    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (Exception ex){
            throw new AuthenticationCredentialsNotFoundException("Jwt expired or incorrect");
        }
    }


    public String getUsernameFromToken(String token){

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }



}
