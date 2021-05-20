package com.kakadurf.cv4.domain.transport;

import com.kakadurf.cv4.domain.entities.MessageEntity;
import com.kakadurf.cv4.domain.transport.dto.MessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper( MessageMapper.class );
    @Mapping(source = "userEntity.name", target = "name")
    MessageDto messageToDto(MessageEntity messageEntity);

}
