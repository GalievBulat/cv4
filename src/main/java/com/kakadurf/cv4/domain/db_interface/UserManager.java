package com.kakadurf.cv4.domain.db_interface;

import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Component
public interface UserManager extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);
}
