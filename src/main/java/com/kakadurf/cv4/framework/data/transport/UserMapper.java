package com.kakadurf.cv4.framework.data.transport;

import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.data.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class );

    UserDto userToDto(UserEntity userEntity);
}
