package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.MessageSource;
import com.kakadurf.cv4.domain.entities.MessageEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.transport.dto.MessageDto;
import com.kakadurf.cv4.domain.transport.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    MessageSource messageSource;
    public MessageEntity saveToDb(MessageEntity messageEntity){
        return messageSource.save(messageEntity);
    }
    public List<MessageDto> getOnesMessages(UserEntity userEntity){
        return messageSource.findByUserEntity(userEntity)
                .stream().map(MessageMapper.INSTANCE::messageToDto)
                .collect(Collectors.toList());
    }
}
