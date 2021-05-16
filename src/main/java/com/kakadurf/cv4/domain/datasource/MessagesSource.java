package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.MessageEntity;

public interface MessagesSource {
    MessageEntity save(MessageEntity messageEntity);
}
