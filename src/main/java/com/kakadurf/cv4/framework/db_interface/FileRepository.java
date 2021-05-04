package com.kakadurf.cv4.framework.db_interface;

import com.kakadurf.cv4.domain.datasource.FileSource;
import com.kakadurf.cv4.domain.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity,Long>, FileSource {

}
