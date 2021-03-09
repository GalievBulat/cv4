package com.kakadurf.cv4.domain.facade;

import com.kakadurf.cv4.domain.UserEntity;

import java.util.Optional;

public interface AuthService {
    Optional<UserEntity> authorize(long tc, String password);
    Optional<UserEntity> connectByTocken(long tc);
}