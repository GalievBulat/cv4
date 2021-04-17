package com.kakadurf.cv4.framework_presentation.db_interface;

import com.kakadurf.cv4.domain.datasource.FileSource;
import com.kakadurf.cv4.domain.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface FileRepository extends JpaRepository<FileEntity,Long>, FileSource {

}
