package com.kakadurf.cv4.data.db;

import com.kakadurf.cv4.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface DbManager extends JpaRepository<UserEntity,Long> {
}
