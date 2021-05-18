package com.kakadurf.cv4.domain.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenizer {
    @Value("${secret_key}")
    private String key;
    public String getToken(long id , String name){
        return Jwts.builder()
                .setSubject("" + id)
                .claim("name", name)
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }
}
