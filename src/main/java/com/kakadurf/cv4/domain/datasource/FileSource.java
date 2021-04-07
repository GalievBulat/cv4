package com.kakadurf.cv4.domain.datasource;

import com.kakadurf.cv4.domain.entities.FileEntity;

import java.util.Optional;

public interface FileSource {
    Optional<FileEntity> getFileEntityByName(String name);
    Optional<FileEntity> getFileEntityByOldName(String name);
    FileEntity save(FileEntity fileEntity);
}
