package com.kakadurf.cv4.data.db;

import com.kakadurf.cv4.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileManager extends JpaRepository<FileEntity,Long> {

}
