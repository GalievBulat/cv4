package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.RegistrationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class RestRegistration {
    @Value("${secret_key}")
    private String key;
    @Autowired
    private UserSource userSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Operation(summary = "Gets a token for a given user users", tags = "user")
    @PostMapping("/api/token")
    public ResponseEntity<String> getUser(@Valid UserData user){
        Optional<UserEntity> entityDB = userSource.findByEmail(user.getEmail());
        if (entityDB.isPresent()) {
            UserEntity entity = entityDB.get();
            if (passwordEncoder.matches(entity.getHashedPassword(),
                    user.getPassword())) {
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
