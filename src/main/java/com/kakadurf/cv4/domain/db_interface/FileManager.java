package com.kakadurf.cv4.domain.db_interface;

import com.kakadurf.cv4.domain.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface FileManager extends JpaRepository<FileEntity,Long> {
    Optional<FileEntity> getFileEntityByName(String name);
    Optional<FileEntity> getFileEntityByOldName(String name);
}
