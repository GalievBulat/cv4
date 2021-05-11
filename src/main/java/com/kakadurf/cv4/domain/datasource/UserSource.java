package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserSource {
    Optional<UserEntity> findById(long tc);
    Optional<UserEntity> findByEmail(String email);
    Page<UserEntity> findUsersByEmail(String email, Pageable pageable);
    Page<UserEntity> findUsersByEmailAndName(String email, String name, Pageable pageable);
    UserEntity save(UserEntity userEntity);
    List<UserEntity> findUserAdmin(String name,
                                   String email,
                                   Pageable pageable);

    List<UserEntity> findUserByNameOrEmail( String name,
                               String email,
                              Pageable pageable);
}
