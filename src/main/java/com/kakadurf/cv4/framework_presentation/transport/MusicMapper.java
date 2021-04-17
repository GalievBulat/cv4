package com.kakadurf.cv4.framework_presentation.transport;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MusicMapper {
    MusicMapper INSTANCE = Mappers.getMapper( MusicMapper.class );

    @Mapping(source = "musicFile.path", target = "filePath")
    MusicDto musicToDto(MusicEntity musicEntity);

}
