package com.kakadurf.cv4.framework.db_interface;

import com.kakadurf.cv4.domain.datasource.MusicSource;
import com.kakadurf.cv4.domain.entities.MusicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity,Long>, MusicSource {
    Page<MusicEntity> findAll(Pageable pageable);
    @Query("SELECT c FROM MusicEntity c WHERE (:name is null or c.name = :name) and (:author is null"
            + " or c.author = :author) and (:album is null or c.album = :album)")
    List<MusicEntity> findMusic(@Param("name") String name,
                                @Param("author") String author,
                                @Param("album") String album
    );
}
