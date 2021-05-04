package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserSource {
    Optional<UserEntity> findById(long tc);
    Optional<UserEntity> findByEmail(String email);
    Page<UserEntity> findUsersByEmail(String email, Pageable pageable);
    UserEntity save(UserEntity userEntity);
}
