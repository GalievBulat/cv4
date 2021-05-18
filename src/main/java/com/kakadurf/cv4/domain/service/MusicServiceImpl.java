package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.MusicSource;
import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.entities.MusicInfo;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.interfaces.MusicService;
import com.kakadurf.cv4.framework.data.dto.MusicDto;
import com.kakadurf.cv4.framework.data.transport.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicSource musicSource;


    public List<MusicDto> getMusicPage(int page, int size){
        return musicSource.findAll(PageRequest.of(page, size))
                .stream().map(MusicMapper.INSTANCE::musicToDto)
                .collect(Collectors.toList());
    }
    public  List<String> findMusicJSONByName(String value){
        return musicSource.findByName(value)
                .stream()
                .map(MusicMapper.INSTANCE::musicToDto)
                .map(MusicDto::toJSON)
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicDto> findMusicPage(MusicInfo musicInfo, int page, int size) {
        return musicSource.findMusic(musicInfo.getName()!= null? musicInfo.getName().length()>0 ? musicInfo.getName() : null: null,
                musicInfo.getAuthor() !=null ? musicInfo.getAuthor().length()>0 ? musicInfo.getAuthor() : null : null,
                musicInfo.getAlbum() != null ? musicInfo.getAlbum().length()>0 ? musicInfo.getAlbum() : null : null)
                .stream()
                .map(MusicMapper.INSTANCE::musicToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MusicDto> getOnesMusic(List<Long> ids, Pageable pageable) {
        return musicSource.findByMusicFile_Owner_IdIn(ids,pageable).stream()
                .map(MusicMapper.INSTANCE::musicToDto).collect(Collectors.toList());
    }

    public void uploadMusic(MusicInfo entity, FileEntity musicFile, UserEntity owner){
        if (musicFile.getType().contains("audio/mpeg")) {
            MusicEntity musicEntity = MusicEntity.builder()
                    .musicFile(musicFile)
                    .name(entity.getName())
                    .album(entity.getAlbum())
                    .author(entity.getAuthor())
                    .build();
            musicSource.save(musicEntity);
        }
    }


}
