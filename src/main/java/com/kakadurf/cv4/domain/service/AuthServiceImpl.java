package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.db_interface.UserManager;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserManager userManager;

    public Optional<UserEntity> authorize(long tc, String password){
        Optional<UserEntity> entity = userManager.findById(tc);
        if (entity.isPresent() && entity.get().getPassword().equals(password)){
            return entity;
        } else
        return Optional.empty();
    }
    public Optional<UserEntity> connectByTocken(long tc){
        return userManager.findById(tc);
    }
}
