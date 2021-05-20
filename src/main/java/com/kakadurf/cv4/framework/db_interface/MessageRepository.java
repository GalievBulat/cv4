package com.kakadurf.cv4.framework.db_interface;

import com.kakadurf.cv4.domain.datasource.MessageSource;
import com.kakadurf.cv4.domain.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Long>, MessageSource {
}
