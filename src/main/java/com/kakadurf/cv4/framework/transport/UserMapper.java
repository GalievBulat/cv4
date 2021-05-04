package com.kakadurf.cv4.framework.transport;

import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class );

    UserDto userToDto(UserEntity userEntity);
}
