package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MusicSource {
    Page<MusicEntity> findByName(String name, Pageable pageable);
    List<MusicEntity> findByName(String name);
    List<MusicEntity> findMusic(String name,
                                String author,
                                String album);
    Page<MusicEntity> findAll(Pageable pageable);
    List<MusicEntity> findByMusicFile_Owner_Id(long id);
    MusicEntity save(MusicEntity var1);
}
