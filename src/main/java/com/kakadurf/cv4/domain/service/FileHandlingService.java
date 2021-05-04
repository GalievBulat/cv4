package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.entities.RowFileData;

public interface FileHandlingService {
     FileEntity saveFile(RowFileData multipartFile);

     FileEntity getFileByOldName(String fileName) throws IllegalAccessException;
     FileEntity getFileByName(String fileName) throws IllegalAccessException;
}
