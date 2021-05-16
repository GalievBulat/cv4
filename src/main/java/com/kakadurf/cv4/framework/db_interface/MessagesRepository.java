package com.kakadurf.cv4.framework.db_interface;

import com.kakadurf.cv4.domain.datasource.MessagesSource;
import com.kakadurf.cv4.domain.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<MessageEntity,Long>, MessagesSource {
}
