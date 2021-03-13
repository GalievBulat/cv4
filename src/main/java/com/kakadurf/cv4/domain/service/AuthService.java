package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.entities.UserEntity;

import java.util.Optional;

public interface AuthService {
    Optional<UserEntity> authorize(long tc, String password);
    Optional<UserEntity> connectByTocken(long tc);
}
