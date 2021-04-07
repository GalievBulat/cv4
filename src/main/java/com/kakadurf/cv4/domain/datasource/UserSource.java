package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserSource {
    Optional<UserEntity> findByEmail(String email);
    Optional<List<UserEntity>> findUsersByEmail(String email, Pageable pageable);
    Optional<UserEntity> findById(long tc);
    UserEntity save(UserEntity userEntity);
}
