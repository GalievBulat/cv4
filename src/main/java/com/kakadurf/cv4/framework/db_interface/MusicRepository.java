package com.kakadurf.cv4.framework.db_interface;

import com.kakadurf.cv4.domain.datasource.MusicSource;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity,Long>, MusicSource {
    Page<MusicEntity> findAll(Pageable pageable);
}
