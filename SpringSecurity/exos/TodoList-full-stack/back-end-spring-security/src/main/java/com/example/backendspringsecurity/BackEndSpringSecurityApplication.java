package com.example.backendspringsecurity;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;

@SpringBootApplication
public class BackEndSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndSpringSecurityApplication.class, args);

        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        String base64Key = Encoders.BASE64.encode(key.getEncoded());

        System.out.println(base64Key);

    }

}
