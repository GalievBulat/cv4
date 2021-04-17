package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.entities.RowFileData;

public interface FileHandlingService {
     FileEntity saveFile(RowFileData multipartFile);

     FileEntity getFile(String fileName) throws IllegalAccessException;
}
