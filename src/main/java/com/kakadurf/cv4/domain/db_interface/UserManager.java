package com.kakadurf.cv4.domain.db_interface;

import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface UserManager extends JpaRepository<UserEntity,Long> {
}
