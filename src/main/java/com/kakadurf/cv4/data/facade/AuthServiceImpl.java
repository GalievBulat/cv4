package com.kakadurf.cv4.data.facade;

import com.kakadurf.cv4.data.db.DbManager;
import com.kakadurf.cv4.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private DbManager dbManager;

    public Optional<UserEntity> authorize(long tc, String password){
        Optional<UserEntity> entity = dbManager.findById(tc);
        if (entity.isPresent() && entity.get().getPassword().equals(password)){
            return entity;
        } else
        return Optional.empty();
    }
    public Optional<UserEntity> connectByTocken(long tc){
        return dbManager.findById(tc);
    }
}
