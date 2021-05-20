package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.MessageEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;

import java.util.List;

public interface MessageSource {
    MessageEntity save(MessageEntity messageEntity);
    List<MessageEntity> findByUserEntity(UserEntity userEntity);
}
