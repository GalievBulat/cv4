package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.FileSource;
import com.kakadurf.cv4.domain.entities.FileEntity;
import com.kakadurf.cv4.domain.entities.RowFileData;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.interfaces.FileHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Service
public class FileHandlingServiceImpl implements FileHandlingService {
    @Value("${project_meta.path}")
    private String path;
    @Autowired
    private FileSource fileSource;
    @Override
    public FileEntity saveFile(RowFileData multipartFile, UserEntity owner) {
        String newFilename = getNewFilename(requireNonNull(multipartFile.getName()));
        FileEntity info = FileEntity.builder()
                .size(multipartFile.getSize())
                .type(multipartFile.getContentType())
                .name(newFilename)
                .path(path + File.separator + newFilename)
                .oldName(multipartFile.getName())
                .owner(owner)
                .build();
        fileSource.save(info);
        File file = new File(path + File.separator + newFilename);
        multipartFile.transfer(file);
        return info;
    }
    private String getNewFilename(String originalFilename) {
        String[] strings = originalFilename.split("\\.");
        return UUID.randomUUID() + "." + strings[strings.length - 1];
    }
    @Override
    public FileEntity getFileByOldName(String fileName) {
        Optional<FileEntity> fileInfo = fileSource.getFileEntityByOldName(fileName);
        if (fileInfo.isPresent()) {
           return  fileInfo.get();
           //TODO(authentication)
            /*if (fileInfo1.getOwner().getId().equals(userId) | fileInfo1.getReceiver().getId().equals(userId)) {
                return new String[]{path + File.separator + fileName, fileInfo1.getType(), fileInfo1.getOriginalFileName()};
            } else {
                throw new IllegalAccessException("Вы не имеете доступа к данным файлам");
            }*/
        } else {
            throw new IllegalArgumentException("Файл не найден");
        }
    }

    @Override
    public FileEntity getFileByName(String fileName) {
        Optional<FileEntity> fileInfo = fileSource.getFileEntityByName(fileName);
        if (fileInfo.isPresent()) {
            return  fileInfo.get();
        } else {
            throw new IllegalArgumentException("Файл не найден");
        }
    }


}