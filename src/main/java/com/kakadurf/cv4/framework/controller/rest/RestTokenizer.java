package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.JwtTokenizer;
import com.kakadurf.cv4.framework.data.dto.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RestTokenizer {
    @Autowired
    JwtTokenizer jwtTokenizer;
    @Autowired
    private UserSource userSource;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Operation(summary = "Gets a token for a given user", tags = "user")
    @PostMapping("/api/token")
    public ResponseEntity<String> getUser(@RequestBody UserInfo user){
        Optional<UserEntity> entityDB = userSource.findById(user.getId());
        if (entityDB.isPresent()) {
            UserEntity entity = entityDB.get();
            if (passwordEncoder.matches( user.getPassword(),
                    entity.getHashedPassword())) {
                return ResponseEntity.ok(jwtTokenizer.getToken(entity.getId(), entity.getName()));
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
