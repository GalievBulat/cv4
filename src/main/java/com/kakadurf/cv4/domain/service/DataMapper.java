package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.entities.UserData;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DataMapper {
    DataMapper INSTANCE = Mappers.getMapper( DataMapper.class );

    @Mapping(source = "phone_num", target = "phoneNum")
    UserEntity userDataToEntity(UserData car);
}
