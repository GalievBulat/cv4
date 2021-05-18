package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.MessagesSource;
import com.kakadurf.cv4.domain.entities.MessageEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.data.dto.MessageDto;
import com.kakadurf.cv4.framework.data.transport.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    MessagesSource messagesSource;
    public MessageEntity saveToDb(MessageEntity messageEntity){
        return messagesSource.save(messageEntity);
    }
    public List<MessageDto> getOnesMessages(UserEntity userEntity){
        return messagesSource.findByUserEntity(userEntity)
                .stream().map(MessageMapper.INSTANCE::messageToDto)
                .collect(Collectors.toList());
    }
}
