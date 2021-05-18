package com.kakadurf.cv4.domain.service.interfaces;

import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.entities.RowFileData;
import com.kakadurf.cv4.domain.entities.UserEntity;

public interface FileHandlingService {
     FileEntity saveFile(RowFileData multipartFile, UserEntity owner);


     FileEntity getFileByOldName(String fileName) throws IllegalAccessException;
     FileEntity getFileByName(String fileName) throws IllegalAccessException;
}
