package com.kakadurf.cv4.framework_presentation.transport;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.framework_presentation.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MusicMapper {
    MusicMapper INSTANCE = Mappers.getMapper( MusicMapper.class );

    @Mapping(source = "musicFile.path", target = "filePath")
    @Mapping(source = "musicFile.owner", target = "provider" , qualifiedBy = UserDtoProvider.class)
    MusicDto musicToDto(MusicEntity musicEntity);

    @UserDtoProvider
    default UserDto getUserDto(UserEntity userEntity){
        return UserMapper.INSTANCE.userToDto(userEntity);
    }

}
