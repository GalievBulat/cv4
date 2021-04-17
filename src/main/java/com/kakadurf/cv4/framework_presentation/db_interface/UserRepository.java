package com.kakadurf.cv4.framework_presentation.db_interface;

import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<UserEntity,Long>, UserSource {
    Optional<UserEntity> findByEmail(String email);
}