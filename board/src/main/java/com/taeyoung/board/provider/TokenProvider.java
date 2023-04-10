package com.taeyoung.board.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenProvider {

    // properties에 있는 값
    @Value("${jwt.security-key}")
    private String SECURITY_KEY;
    
    public String create(String email) {

        Date expirDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt = Jwts.builder()
                        .signWith(SignatureAlgorithm.HS256, SECURITY_KEY)
                        .setSubject(email).setIssuedAt(new Date()).setExpiration(expirDate)
                        .compact();
        return jwt;

    }

    public String validate (String jwt) {
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY)
                        .parseClaimsJws(jwt).getBody();

        return claims.getSubject();
    }

}
