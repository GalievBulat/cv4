package com.kakadurf.cv4.framework.data.transport;

import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework.data.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class );

    //@Mapping(source = "subscribes", target = "subscribedId" , qualifiedBy = SubscribedIdProvider.class)
    UserDto userToDto(UserEntity userEntity);
    /*@SubscribedIdProvider
    default Set<Long> getSubscribedIds(Set<UserEntity> subscribes ){
        Set<Long> ids= new HashSet<>();
        for (UserEntity subscribed : subscribes){
            ids.add(subscribed.getId());
        }
        return ids;
        //return subscribes.stream().map(UserEntity::getId).collect(Collectors.toSet());
    }*/
}
