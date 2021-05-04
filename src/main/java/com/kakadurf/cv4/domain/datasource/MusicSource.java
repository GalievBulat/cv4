package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MusicSource {
    Page<MusicEntity> findByName(String name, Pageable pageable);
    List<MusicEntity> findByName(String name);
    List<MusicEntity> findMusic(String name,
                                String author,
                                String album);
    Page<MusicEntity> findAll(Pageable pageable);
    MusicEntity save(MusicEntity var1);
}
