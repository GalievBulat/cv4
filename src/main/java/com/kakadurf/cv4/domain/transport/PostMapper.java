package com.kakadurf.cv4.domain.transport;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.entities.PostEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.transport.dto.MusicDto;
import com.kakadurf.cv4.domain.transport.dto.PostDto;
import com.kakadurf.cv4.domain.transport.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );

    @Mapping(source = "parent.id", target = "parentId")
    @Mapping(source = "liked", target = "liked", qualifiedBy = ListSizeProvider.class)
    @Mapping(source = "owner", target = "owner", qualifiedBy = UserDtoProvider.class)
    @Mapping(source = "music", target = "music", qualifiedBy = MusicDtoProvider.class)
    PostDto postToDto(PostEntity post);
    @UserDtoProvider
    default UserDto getUserDto(UserEntity userEntity){
        return MusicMapper.INSTANCE.getUserDto(userEntity);
    }
    @MusicDtoProvider
    default MusicDto getMusicDto(MusicEntity musicEntity){
        return MusicMapper.INSTANCE.musicToDto(musicEntity);
    }
    @ListSizeProvider
    default int getSize(Collection<?> collection){
        return collection.size();
    }
}
