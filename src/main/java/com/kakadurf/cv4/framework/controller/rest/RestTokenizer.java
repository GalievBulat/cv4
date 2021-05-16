package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.data.dto.UserInfo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RestTokenizer {
    @Value("${secret_key}")
    private String key;
    @Autowired
    private UserSource userSource;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Operation(summary = "Gets a token for a given user", tags = "user")
    @PostMapping("/api/token")
    public ResponseEntity<String> getUser(@RequestBody UserInfo user){
        Optional<UserEntity> entityDB = userSource.findById(user.getId());
        if (entityDB.isPresent()) {
            UserEntity entity = entityDB.get();
            if (passwordEncoder.matches( user.getPassword(),
                    entity.getHashedPassword())) {
                return ResponseEntity.ok(Jwts.builder()
                        .setSubject(entity.getId().toString())
                        .claim("name", entity.getName())
                        .signWith(SignatureAlgorithm.HS256,key)
                        .compact());
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
