package com.kakadurf.cv4.framework_presentation.db_interface;

import com.kakadurf.cv4.domain.entities.MusicEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface MusicRepository extends JpaRepository<MusicEntity,Long> {
    //Optional<MusicEntity> findById(long id);
    Optional<List<MusicEntity>> findByName(String name, Pageable pageable);
}
