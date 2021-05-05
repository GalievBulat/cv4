package com.kakadurf.cv4.framework.db_interface;

import com.kakadurf.cv4.domain.datasource.SubscribeSource;
import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.Subscribe;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribesRepository extends JpaRepository<Subscribe,Long>, SubscribeSource {
}
