package com.kakadurf.cv4.framework_presentation.transport;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework_presentation.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class );

    UserDto userToDto(UserEntity userEntity);
}
